package com.amin.e_commerce.product.application.service.impl;

import com.amin.e_commerce.category.application.service.CategoryQueryService;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.product.api.dto.ProductCreateRequest;
import com.amin.e_commerce.product.api.dto.ProductPageRequest;
import com.amin.e_commerce.product.api.dto.ProductUpdateRequest;
import com.amin.e_commerce.product.application.service.ProductManagementService;
import com.amin.e_commerce.product.application.service.ProductQueryService;
import com.amin.e_commerce.product.domain.command.ProductUpdateCommand;
import com.amin.e_commerce.product.domain.factory.ProductFactory;
import com.amin.e_commerce.product.domain.model.Product;
import com.amin.e_commerce.product.domain.repository.ProductRepository;
import com.amin.e_commerce.product.domain.value.ProductCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    private final ProductRepository productRepository;
    private final ProductFactory productFactory;
    private final ProductQueryService productQueryService;
    private final CategoryQueryService categoryQueryService;
    private final ActorProvider actorProvider;
    private final BusinessEventLogger businessEventLogger;

    @Override
    public Product create(ProductCreateRequest request) {
        CategoryCode categoryCode = CategoryCode.of(request.getCategoryCode());
        Category category = categoryQueryService.getByCode(categoryCode);

        // Domain logic
        Product newProduct = productFactory.create(request, category);

        // Persist
        Product saved = productRepository.save(newProduct);

        // Log the business operation event
        businessEventLogger.productCreated(
                saved.getCode()
        );

        return saved;
    }

    @Override
    public Product update(ProductCode code, ProductUpdateRequest request) {
        Product product = productQueryService.getByCode(code);

        ProductUpdateCommand command = ProductUpdateCommand.of(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getStatus(),
                request.getCategoryCode()
                        == null ? null : categoryQueryService.getByCode(CategoryCode.of(request.getCategoryCode()))

        );

        // Domain logic
        product.update(command);

        // Persist
        Product saved = productRepository.save(product);

        // Log the business operation event
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
    public PageResult<Product> list(ProductPageRequest request) {
        PageResult<Product> products = productRepository.findAll(request);

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
    public PageResult<Product> listByCategoryCode(CategoryCode categoryCode, ProductPageRequest request) {
        PageResult<Product> products = productRepository.findAllByCategoryCode(
                categoryCode.toString(),
                request
        );

        // Log the business operation event
        businessEventLogger.productListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy(),
                request.getDirection()
        );

        return products;
    }
}
