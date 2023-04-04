package com.francortiz.Shop.services;

import com.francortiz.Shop.models.Cart;

public interface ICartService {
    Cart findByUserId(Long id);

    Cart save(Cart cart);

    Cart update(Cart cart, Long id);

    void deleteById(Long id);

    Cart addItem(Long item, Cart cart, Integer amount);
}
