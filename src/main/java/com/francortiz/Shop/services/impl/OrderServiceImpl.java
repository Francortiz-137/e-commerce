package com.francortiz.Shop.services.impl;

import com.francortiz.Shop.models.Order;
import com.francortiz.Shop.models.OrderItem;
import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.repositories.OrderRepository;
import com.francortiz.Shop.repositories.ProductRepository;
import com.francortiz.Shop.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Order> findByUserId(Long id) {
        return orderRepository.findByUserId(id) ;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order, Long id) {

        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteByUserId(id);
    }

    @Override
    public Order addItem(Long itemId, Order order, Integer amount) {
        Product item =  productRepository.findById(itemId).orElse(null); //TODO add exception
        OrderItem orderItem = new OrderItem(item, amount);
        order.addOrderItems(orderItem);
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get() ;
    }
}
