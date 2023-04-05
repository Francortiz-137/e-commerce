package com.francortiz.Shop.repositories;

import com.francortiz.Shop.models.Cart;
import com.francortiz.Shop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUserId(Long id);

    void deleteByUserId(Long id);
}
