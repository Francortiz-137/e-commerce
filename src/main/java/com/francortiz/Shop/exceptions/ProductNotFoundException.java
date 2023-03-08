package com.francortiz.Shop.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class ProductNotFoundException extends ResourceNotFoundException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
