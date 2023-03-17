package com.francortiz.Shop.controllers;

import com.francortiz.Shop.models.User;
import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","*"})
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

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return new ResponseEntity<>( userService.save(user),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.update(user,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
