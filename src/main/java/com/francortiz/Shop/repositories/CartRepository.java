package com.francortiz.Shop.repositories;

import com.francortiz.Shop.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
