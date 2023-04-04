package com.francortiz.Shop.controllers;

import com.francortiz.Shop.models.Cart;
import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.models.User;
import com.francortiz.Shop.services.ICartService;
import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","*"})
@RequestMapping("/api/users")
public class CartController {

    @Autowired
    IUserService userService;

    @Autowired
    ICartService cartService;

    @GetMapping("/{id}/cart")
    public ResponseEntity<?> getUserCart(@PathVariable Long id){
        return new ResponseEntity<>( cartService.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> createUserCart(@RequestBody Cart cart){
        return new ResponseEntity<>( cartService.save(cart),HttpStatus.OK);
    }

    @PutMapping("/{id}/cart")
    public ResponseEntity<?> updateUserCart(@RequestBody Cart cart, @PathVariable Long id){
        return new ResponseEntity<>(cartService.update(cart,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/cart")
    public ResponseEntity<?> deleteUserCart(@PathVariable Long id){
        cartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/cart")
    public ResponseEntity<?> addCartItem(@RequestParam Long itemId, @RequestParam Integer amount, @PathVariable Long id){
        User user = userService.findById(id);
        Cart cart = user.getCart();
        return new ResponseEntity<>(cartService.addItem(itemId, cart, amount),HttpStatus.OK);
    }
}