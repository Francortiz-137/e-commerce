package com.francortiz.Shop.controllers;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","*"})
@RequestMapping("/api")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Product>> listItems(@RequestParam(required = false) List<Type> filters){
        if(filters == null || filters.isEmpty() )
            return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
        return new ResponseEntity<List<Product>>(productService.findAllByTypeIn(filters), HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Product> getItem(@PathVariable Long id){
        return new ResponseEntity<Product>(productService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<Product> addItem(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Product> editItem(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
    }
}
