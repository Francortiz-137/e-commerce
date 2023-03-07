package com.francortiz.Shop.controllers;

import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Product>> listItems(){
        return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/items/{:id}")
    public ResponseEntity<Product> getItem(@RequestParam Long id){
        return new ResponseEntity<Product>(productService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<Product> addItem(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
    }

    @DeleteMapping("/items/{:id}")
    public ResponseEntity<?> deleteItem(@RequestParam Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Product> editItem(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
    }
}
