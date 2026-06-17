package com.amin.e_commerce.category.domain.model;

import com.amin.e_commerce.category.domain.command.CategoryCreateCommand;
import com.amin.e_commerce.category.domain.command.CategoryUpdateCommand;
import com.amin.e_commerce.category.exception.CategoryTechnicalException;
import com.amin.e_commerce.core.audit.LifecycleAuditableEntity;
import com.amin.e_commerce.identity.core.model.Actor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "categories")
@SQLRestriction("deleted_at IS NULL")
public class Category extends LifecycleAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "code",nullable = false,updatable = false,unique = true)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status",nullable = false)
    private CategoryStatus status;


    // -------------------------------------------------- Methods -------------------------------------------------- //

    public static Category create(@NotNull CategoryCreateCommand command){
        if (command == null) {
            throw CategoryTechnicalException.createCommandNull();
        }

        return Category.builder()
                .code(command.code().toString())
                .name(command.name().toString())
                .description(command.description().toString())
                .status(CategoryStatus.INACTIVE)
                .build();
    }

    public void update(CategoryUpdateCommand command){
        if (command == null) {
            throw CategoryTechnicalException.updateCommandNull();
        }

        command.name().ifPresent(categoryName -> this.name = categoryName.toString());
        command.description().ifPresent(categoryDescription -> this.description = categoryDescription.toString());
        command.status().ifPresent(categoryStatus -> this.status = categoryStatus);

    }

    public void delete(Actor actor) {
        super.delete(actor);
        this.status = CategoryStatus.INACTIVE;
    }

    // ----------------------------------------------- End Methods ------------------------------------------------- //



}
