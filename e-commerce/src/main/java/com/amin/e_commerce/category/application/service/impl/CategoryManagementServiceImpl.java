package com.amin.e_commerce.category.application.service.impl;

import com.amin.e_commerce.category.api.dto.CategoryCreateRequest;
import com.amin.e_commerce.category.api.dto.CategoryPageRequest;
import com.amin.e_commerce.category.api.dto.CategoryUpdateRequest;
import com.amin.e_commerce.category.application.service.CategoryManagementService;
import com.amin.e_commerce.category.application.service.CategoryQueryService;
import com.amin.e_commerce.category.domain.command.CategoryUpdateCommand;
import com.amin.e_commerce.category.domain.factory.CategoryFactory;
import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.category.domain.repository.CategoryRepository;
import com.amin.e_commerce.category.domain.value.CategoryCode;
import com.amin.e_commerce.category.domain.value.CategoryName;
import com.amin.e_commerce.category.exception.CategoryBusinessException;
import com.amin.e_commerce.core.logging.audit.BusinessEventLogger;
import com.amin.e_commerce.core.pagination.PageResult;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CategoryManagementServiceImpl implements CategoryManagementService {
    private final CategoryFactory categoryFactory;
    private final CategoryRepository categoryRepository;
    private final CategoryQueryService categoryQueryService;
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

        // Persist
        Category saved = categoryRepository.save(newCategory);

        // Log the business operation event
        businessEventLogger.categoryCreated(
                saved.getCode()
        );

        return saved;
    }

    @Transactional
    @Override
    public Category update(CategoryCode code, CategoryUpdateRequest request) {

        Category category = categoryQueryService.getByCode(code);

        validateUpdate(category, request);

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

        PageResult<Category> categories = categoryRepository.findAll(request);

        businessEventLogger.categoryListed(
                request.getPage(),
                request.getSize(),
                request.getSortBy().toString(),
                request.getDirection().toString()
        );

        return categories;
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
