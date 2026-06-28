package com.amin.e_commerce.category.application.service.impl;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.application.service.CategoryManagementService;
import com.amin.e_commerce.category.application.service.CategoryQueryService;
import com.amin.e_commerce.category.domain.command.CategoryUpdateCommand;
import com.amin.e_commerce.category.domain.factory.CategoryFactory;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.model.CategoryImagePreset;
import com.amin.e_commerce.category.domain.repository.CategoryRepository;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.amin.e_commerce.category.exception.CategoryBusinessException;
import com.amin.e_commerce.category.exception.CategoryTechnicalException;
import com.amin.e_commerce.category.exception.CategoryValidationException;
import com.amin.e_commerce.core.exception.core.BaseException;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.api.pagination.PageResult;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import com.amin.e_commerce.media.core.model.MediaOwnerType;
import com.amin.e_commerce.media.image.application.service.ImageService;
import com.amin.e_commerce.media.image.domain.model.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class CategoryManagementServiceImpl implements CategoryManagementService {
    private final CategoryFactory categoryFactory;
    private final CategoryRepository categoryRepository;
    private final CategoryQueryService categoryQueryService;
    private final ImageService imageService;
    private final ActorProvider actorProvider;
    private final BusinessEventLogger businessEventLogger;

    @Transactional
    @Override
    public Category create(CategoryCreateRequest request) {
        ensureNameUnique(
                CategoryName.of(request.getName())
        );

        // Domain logic
        Category newCategory = categoryFactory.create(request);

        Image image = null;

        try {

            image = createCategoryImage(request.getImage());

            newCategory.attachImage(image);

            // Persist
            Category saved = categoryRepository.save(newCategory);

            // Log the business operation event
            businessEventLogger.categoryCreated(
                    saved.getCode()
            );

            return saved;

        } catch (BaseException e) {

            // Delete the image if it was created
            if(image != null){
                imageService.delete(image);
            }

            throw e;
        }


    }

    @Transactional
    @Override
    public Category update(CategoryCode code, CategoryUpdateRequest request) {

        Category category = categoryQueryService.getByCode(code);

        validateUpdate(category, request);

        if (request.getImage() != null) {

            Image updatedImage = updateImage(
                    category.getImage(),
                    request.getImage()
            );

            category.replaceImage(updatedImage);
        }

        CategoryUpdateCommand command = CategoryUpdateCommand.of(request);

        // Domain logic
        category.update(command);

        // Persist
        Category saved = categoryRepository.save(category);

        // Log the business operation event
        businessEventLogger.categoryUpdated(
                saved.getCode()
        );

        return saved;
    }


    @Override
    public void delete(CategoryCode code) {
        Category category = categoryQueryService.getByCode(code);
        Actor actor = actorProvider.getCurrent();

        // Domain logic
        category.delete(actor);

        // Persist
        categoryRepository.save(category);

        // Log the business operation event
        businessEventLogger.categoryDeleted(
                code.toString()
        );
    }

    @Override
    public Category view(CategoryCode code) {
        Category category = categoryQueryService.getByCode(code);

        // Log the business operation event
        businessEventLogger.categoryViewed(
                code.toString()
        );

        return category;
    }

    @Transactional
    @Override
    public PageResult<Category> list(CategoryPageRequest request) {

        PageResult<Category> categories = categoryQueryService.getAll(request);

        businessEventLogger.categoryListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy(),
                request.getDirection()
        );

        return categories;
    }


    // -------------------------------------------- Private Methods -------------------------------------------- //

    private Image createCategoryImage(MultipartFile imageFile) {
        if (imageFile == null || imageFile.isEmpty()) {
            throw CategoryValidationException.invalidImage()
                    .withClientDetails("reason", "Image file must be not null or empty");
        }

        try {
            return imageService.create(
                    imageFile,
                    CategoryImagePreset.INSTANCE,
                    MediaOwnerType.CATEGORY
            );
        } catch (BaseException e) {
            throw CategoryTechnicalException.failedToSaveImage(e);
        }
    }

    private Image updateImage(Image existingImage, MultipartFile nweImageFile) {

        try {
            return imageService.update(
                    existingImage,
                    nweImageFile,
                    CategoryImagePreset.INSTANCE,
                    MediaOwnerType.CATEGORY
            );
        } catch (BaseException e) {
            throw CategoryTechnicalException.failedToSaveImage(e);
        }

    }

    private void ensureNameUnique(CategoryName name) {

        if (categoryQueryService.existsByName(name)) {
            throw CategoryBusinessException.nameAlreadyExists()
                    .withDebugDetails("name", name.toString());
        }
    }

    public void validateUpdate(Category category , CategoryUpdateRequest request) {
        String newName = request.getName();
        if (newName != null && !category.getName().equals(newName)){
            ensureNameUnique(CategoryName.of(newName));
        }
    }
}
