package com.amin.e_commerce.product.application.service.impl;

import com.amin.e_commerce.category.application.service.CategoryQueryService;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.exception.core.BaseException;
import com.amin.e_commerce.core.logging.event.BusinessEventLogger;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.integration.stock.gateway.StockGateway;
import com.amin.e_commerce.media.core.model.MediaOwnerType;
import com.amin.e_commerce.media.image.application.service.ImageService;
import com.amin.e_commerce.media.image.domain.model.Image;
import com.amin.e_commerce.product.api.dto.ProductCreateRequest;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.api.dto.ProductUpdateRequest;
import com.amin.e_commerce.product.application.service.ProductManagementService;
import com.amin.e_commerce.product.application.service.ProductQueryService;
import com.amin.e_commerce.product.domain.command.ProductCreateCommand;
import com.amin.e_commerce.product.domain.command.ProductUpdateCommand;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.model.ProductImagePreset;
import com.amin.e_commerce.product.domain.repository.ProductRepository;
import com.amin.e_commerce.product.domain.value.ProductCode;
import com.amin.e_commerce.product.exception.ProductBusinessException;
import com.amin.e_commerce.product.exception.ProductTechnicalException;
import com.amin.e_commerce.product.exception.ProductValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    private final ProductRepository productRepository;
    private final ProductQueryService productQueryService;
    private final CategoryQueryService categoryQueryService;
    private final ImageService imageService;
    private final ActorProvider actorProvider;
    private final StockGateway stockGateway;
    private final BusinessEventLogger businessEventLogger;

    @Transactional
    @Override
    public Product create(ProductCreateRequest request) {

        CategoryCode categoryCode = CategoryCode.of(request.getCategoryCode());
        Category category = categoryQueryService.getByCode(categoryCode);


        ProductCreateCommand command = ProductCreateCommand.of(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                category
        );


        Product newProduct = Product.create(command);

        Image primaryImage = null;
        List<Image> galleryImages = List.of();

        try {

            primaryImage = uploadImageToStorage(
                    request.getPrimaryImage()
            );

            galleryImages = uploadImagesToStorage(
                    request.getGalleryImages()
            );

            newProduct.addPrimaryImage(primaryImage);
            newProduct.addGalleryImages(galleryImages);

            Product saved = productRepository.save(newProduct);

            businessEventLogger.productCreated(
                    saved.getCode()
            );

            return saved;

        } catch (BaseException e) {

            if (primaryImage != null) {
                imageService.delete(primaryImage);
            }

            galleryImages.forEach(
                    imageService::delete
            );

            throw e;
        }
    }

    @Transactional
    @Override
    public Product update(ProductCode code, ProductUpdateRequest request) {

        Product product = productQueryService.getByCode(code);

        ProductUpdateCommand command = ProductUpdateCommand.of(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getCategoryCode()
                        == null ? null : categoryQueryService.getByCode(
                                CategoryCode.of(request.getCategoryCode())
                )
        );

        if (request.getPrimaryImage() != null) {

            Image updatedPrimary = updateImageInStorage(
                    product.getPrimaryImage(),
                    request.getPrimaryImage()
            );

            product.updatePrimaryImage(updatedPrimary);
        }

        if (request.getGalleryImages() != null && !request.getGalleryImages().isEmpty()) {

            List<Image> newGallery = replaceImagesInStorage(
                    product.getGalleryImages(),
                    request.getGalleryImages()
            );

            product.replaceGalleryImages(newGallery);
        }

        product.update(command);

        Product saved = productRepository.save(product);

        businessEventLogger.productUpdated(
                saved.getCode()
        );

        return saved;
    }

    @Override
    public void delete(ProductCode code) {
        Product product = productQueryService.getByCode(code);
        Actor actor = actorProvider.getCurrent();

        // Domain logic
        product.delete(actor);

        // Persist
        productRepository.save(product);

        // Log the business operation event
        businessEventLogger.productDeleted(
                code.toString()
        );
    }

    @Override
    public Product view(ProductCode code) {
        Product product = productQueryService.getByCode(code);

        // Log the business operation event
        businessEventLogger.productViewed(
                code.toString()
        );

        return product;
    }

    @Override
    public Product viewPurchasable(ProductCode code) {
        Product product = productQueryService.getPurchasableByCode(code);

        // Log the business operation event
        businessEventLogger.productViewed(
                code.toString()
        );

        return product;
    }

    @Override
    public PageResult<Product> list(CategoryCode categoryCode, ProductPageRequest request) {
        PageResult<Product> products;

        if (categoryCode == null) {
            products = productQueryService.getAll(request);
        } else {
            categoryQueryService.getByCode(categoryCode);
            products = productQueryService.getAllByCategoryCode(categoryCode, request);
        }

        // Log the business operation event
        businessEventLogger.productListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy(),
                request.getDirection()
        );

        return products;
    }

    @Override
    public PageResult<Product> listPurchasable(CategoryCode categoryCode, ProductPageRequest request) {
        PageResult<Product> products ;

        if (categoryCode == null) {
            products = productQueryService.getAllPurchasable(request);
        } else {
            categoryQueryService.getByCode(categoryCode);
            products = productQueryService.getAllPurchasableByCategoryCode(categoryCode, request);
        }

        // Log the business operation event
        businessEventLogger.productListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy(),
                request.getDirection()
        );

        return products;
    }

    @Override
    @Transactional
    public void connectStock(ProductCode productCode , String stockCode) {
        Product product = productQueryService.getByCode(productCode);

        if (!stockGateway.stockExists(stockCode)){
            throw ProductBusinessException.stockNotInitialized();
        }

        product.connectStock(stockCode);

        // Log the business operation event
        businessEventLogger.productStockConnected(
                productCode.toString(),
                stockCode
        );


        productRepository.save(product);
    }

    @Transactional
    @Override
    public void publish(ProductCode productCode) {

        Product product = productQueryService.getByCode(productCode);

        product.publish();

        // Log the business operation event
        businessEventLogger.productPublished(
                productCode.toString()
        );

        productRepository.save(product);
    }

    @Transactional
    @Override
    public void unPublish(ProductCode productCode){

        Product product = productQueryService.getByCode(productCode);

        product.unPublish();

        // Log the business operation event
        businessEventLogger.productUnpublished(
                productCode.toString()
        );

        productRepository.save(product);
    }

    // ----------------------------------- Helper Methods ----------------------------------- //


    private Image uploadImageToStorage(MultipartFile imageFile) {
        if (imageFile == null || imageFile.isEmpty()){
            throw ProductValidationException.invalidImage()
                    .withClientDetails("reason", "Image file must be not null or empty");
        }

        try {

            return imageService.create(
                    imageFile,
                    ProductImagePreset.INSTANCE,
                    MediaOwnerType.PRODUCT
            );

        } catch (BaseException e) {

            throw ProductTechnicalException.failedToSaveImage(e);
        }
    }

    private List<Image> uploadImagesToStorage(List<MultipartFile> imageFiles) {

        if (imageFiles == null || imageFiles.isEmpty()) {
            return List.of();
        }

        return imageFiles
                .stream()
                .map(this::uploadImageToStorage)
                .toList();


    }

    private List<Image> replaceImagesInStorage(List<Image> existingImages , List<MultipartFile> multipartFiles){

        if (multipartFiles == null || multipartFiles.isEmpty()) {
            return existingImages;
        }

        deleteImagesFromStorage(existingImages);


        return uploadImagesToStorage(multipartFiles);
    }

    private void deleteImagesFromStorage(List<Image> images) {
        if (images == null || images.isEmpty()) {
            return;
        }

        images.forEach(this::deleteImageFromStorage);
    }

    private void deleteImageFromStorage(Image image){
        if (image == null) {
            return;
        }

        try {
            imageService.delete(image);
        } catch (BaseException e){

            throw ProductTechnicalException.failedToDeleteImage(e);

        }

    }

    private Image updateImageInStorage(Image existingImage, MultipartFile newImageFile) {

        if (newImageFile == null || newImageFile.isEmpty()) {
            return existingImage;
        }

        try {

            return imageService.update(
                    existingImage,
                    newImageFile,
                    ProductImagePreset.INSTANCE,
                    MediaOwnerType.PRODUCT
            );

        } catch (BaseException e) {

            throw ProductTechnicalException.failedToSaveImage(e);
        }

    }



}
