package com.francortiz.Shop.services;

import com.francortiz.Shop.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findByUserId(Long id);

    Order save(Order order);

    Order update(Order order, Long id);

    void deleteById(Long id);

    Order addItem(Long item, Order order, Integer amount);

    Order findById(Long orderId);
}
