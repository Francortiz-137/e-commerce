package com.francortiz.Shop.repositories;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByTypeIn(List<Type> filters);
}
