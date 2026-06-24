package com.amin.e_commerce.cart.application.service;

import com.amin.e_commerce.cart.api.dto.CartAddItemRequest;
import com.amin.e_commerce.cart.api.dto.CartUpdateItemQuantityRequest;
import com.amin.e_commerce.cart.domain.model.Cart;
import com.amin.e_commerce.product.domain.value.ProductCode;

public interface CartManagementService {

    Cart addItem(CartAddItemRequest request);
    Cart updateItemQuantity(CartUpdateItemQuantityRequest request);
    Cart deleteItem(ProductCode productCode);
    Cart clearCart();
    Cart view();
}
