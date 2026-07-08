package com.amin.e_commerce.product.domain.model;


public enum ProductStatus {
    // product is created but not published ,
    // Not visible to customers only visible to catalog managers,
    // Catalog managers are still preparing it.
    DRAFT,

    // Published , Visible and Purchasable
    // The business has approved this product for sale.
    // Must be connected to inventory. ( stock_code != null ) Inventory exists but may not have quantity yet.
    PUBLISHED,

    // Removed from sale , No new purchases ,Historical orders remain valid
    UNPUBLISHED

    ;
    public static ProductStatus getDefault() {
        return ProductStatus.DRAFT;
    }
}
