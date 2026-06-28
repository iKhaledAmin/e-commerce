package com.amin.e_commerce.product.domain.model;

import com.amin.e_commerce.media.image.domain.model.Image;
import com.amin.e_commerce.product.exception.ProductTechnicalException;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false,
            orphanRemoval = true
    )
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @Column(name = "primary_image", nullable = false)
    private boolean primaryImage;


    // ------------------------------------------------ Methods ----------------------------------------------------//


    public boolean isPrimary() {
        return primaryImage;
    }

    public static ProductImage primary(Product product, Image image) {

        validate(product, image);

        return ProductImage.builder()
                .product(product)
                .image(image)
                .primaryImage(true)
                .build();
    }

    public static ProductImage gallery(Product product, Image image) {

        validate(product, image);

        return ProductImage.builder()
                .product(product)
                .image(image)
                .primaryImage(false)
                .build();
    }

    private static void validate(Product product, Image image) {
        if (product == null) throw ProductTechnicalException.nullProduct();

        if (image == null) throw ProductTechnicalException.nullImage();
    }
}