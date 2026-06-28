package com.amin.e_commerce.product.domain.model;

import com.amin.e_commerce.category.domain.model.Category;
import com.amin.e_commerce.core.audit.LifecycleAuditableEntity;
import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.media.image.domain.model.Image;
import com.amin.e_commerce.product.domain.command.ProductCreateCommand;
import com.amin.e_commerce.product.domain.command.ProductUpdateCommand;
import com.amin.e_commerce.product.exception.ProductTechnicalException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "products")
@SQLRestriction("deleted_at IS NULL")
public class Product extends LifecycleAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "code",nullable = false,updatable = false,unique = true)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
   private ProductStatus status;


    // --------------------------------------------------- Relations --------------------------------------------------- //

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductImage> productImages;


    // ------------------------------------------------- End Relations ------------------------------------------------- //

    // --------------------------------------------------- Methods --------------------------------------------------- //

    public static Product create(ProductCreateCommand command) {

        if (command == null) {
            throw ProductTechnicalException.nullCreateCommand();
        }

        return Product.builder()
                .code(command.code().toString())
                .name(command.name().toString())
                .description(command.description().toString())
                .price(command.price().value())
                .status(ProductStatus.getDefault())
                .category(command.category())
                .productImages(new ArrayList<>())
                .build();
    }

    public void update(ProductUpdateCommand command) {

        if (command == null) {
            throw ProductTechnicalException.nullUpdateCommand();
        }

        command.name()
                .ifPresent(value -> this.name = value.toString());

        command.description()
                .ifPresent(value -> this.description = value.toString());

        command.price()
                .ifPresent(value -> this.price = value.value());

        command.status()
                .ifPresent(value -> this.status = value);

        command.category()
                .ifPresent(value -> this.category = value);
    }

    public void delete(Actor actor) {
        super.delete(actor);
        this.status = ProductStatus.INACTIVE;
    }


    public void addPrimaryImage(Image image) {

        if (image == null) {
            throw ProductTechnicalException.nullImage();
        }

        this.productImages.add(
                ProductImage.primary(this, image)
        );
    }

    public void addGalleryImages(List<Image> images) {

        if (images == null || images.isEmpty()) {
            return;
        }

        images.forEach(image ->
                this.productImages.add(
                        ProductImage.gallery(this, image)
                )
        );
    }

    public void updatePrimaryImage(Image image) {

        if (image == null) {
            throw ProductTechnicalException.nullImage();
        }

        if (getPrimaryImage().hasSameIdentity(image)){
            return;
        }

        removePrimaryImage();

        addPrimaryImage(image);
    }

    public void replaceGalleryImages(List<Image> images) {

        removeAllGalleryImages();

        addGalleryImages(images);
    }

    public Image getPrimaryImage() {

        if (productImages == null) {
            return null;
        }

        return productImages.stream()
                .filter(ProductImage::isPrimary)
                .findFirst()
                .map(ProductImage::getImage)
                .orElse(null);
    }

    public List<Image> getGalleryImages() {

        if (productImages == null) {
            return List.of();
        }

        return productImages
                .stream()
                .filter(image -> !image.isPrimary())
                .map(ProductImage::getImage)
                .toList();
    }


    private void removePrimaryImage() {
        productImages.removeIf(ProductImage::isPrimary);
    }
    private void removeAllGalleryImages() {
        productImages.removeIf(image -> !image.isPrimary());
    }

    // ------------------------------------------------- End Methods ------------------------------------------------- //





}
