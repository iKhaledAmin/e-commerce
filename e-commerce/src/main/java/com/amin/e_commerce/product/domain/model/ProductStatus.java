package com.amin.e_commerce.product.domain.model;


public enum ProductStatus {
    // product is created but not published ,
    // Not visible to customers only visible to catalog managers,
    // Catalog managers are still preparing it.
    DRAFT,

    // Published , Visible and Purchasable
    // The business has approved this product for sale.
    // Not We have stock.,Not Inventory exists. Not Warehouse has quantity.
    // Activation is a commerce decision while Inventory is an operational decision.
    ACTIVE,

    // Removed from sale , No new purchases ,Historical orders remain valid
    INACTIVE

    ;
    public static ProductStatus getDefault() {
        return ProductStatus.DRAFT;
    }
}
