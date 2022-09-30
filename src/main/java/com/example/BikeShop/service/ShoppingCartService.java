package com.example.BikeShop.service;

import com.example.BikeShop.model.ShoppingCart;
import com.example.BikeShop.model.dto.ChargeRequest;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart findActiveShoppingCartByUsername(String userId);

    List<ShoppingCart> findAllByUsername(String userId);

    ShoppingCart createNewShoppingCart(String userId);

    ShoppingCart addProductToShoppingCart(String userId,
                                          Long productId);

    ShoppingCart removeProductFromShoppingCart(String userId,
                                               Long productId);

    ShoppingCart getActiveShoppingCart(String userId);

    ShoppingCart cancelActiveShoppingCart(String userId);

    ShoppingCart checkoutShoppingCart(String userId, ChargeRequest chargeRequest);

}
