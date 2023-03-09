package com.francortiz.Shop.controllers;

import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> listUsers(){

        return new ResponseEntity<>( userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return new ResponseEntity<>( userService.findById(id), HttpStatus.OK);
    }

}
