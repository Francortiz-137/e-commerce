package com.francortiz.Shop.services;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.models.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findAllByTypeIn(List<Type> filters);
}
