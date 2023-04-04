package com.francortiz.Shop.services.impl;

import com.francortiz.Shop.models.Cart;
import com.francortiz.Shop.models.CartItem;
import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.repositories.CartRepository;
import com.francortiz.Shop.repositories.ProductRepository;
import com.francortiz.Shop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Cart findByUserId(Long id) {
        return cartRepository.findByUserId(id).get() ;
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart, Long id) {

        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteByUserId(id);
    }

    @Override
    public Cart addItem(Long itemId, Cart cart, Integer amount) {
        Product item =  productRepository.findById(itemId).orElse(null); //TODO add exception
        CartItem cartItem = new CartItem(item, amount);
        cart.addCartItems(cartItem);
        return cartRepository.save(cart);
    }
}
