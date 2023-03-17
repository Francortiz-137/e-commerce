package com.francortiz.Shop.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}