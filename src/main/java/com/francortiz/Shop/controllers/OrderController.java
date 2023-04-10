package com.francortiz.Shop.controllers;

import com.francortiz.Shop.models.Order;
import com.francortiz.Shop.models.Product;
import com.francortiz.Shop.models.User;
import com.francortiz.Shop.services.IOrderService;
import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"http://localhost:4200","*"})
@RequestMapping("/api/users")
public class OrderController {

    @Autowired
    IUserService userService;

    @Autowired
    IOrderService orderService;

    @GetMapping("/{id}/order")
    public ResponseEntity<?> getUserOrders(@PathVariable Long id){
        return new ResponseEntity<>( orderService.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<?> createUserOrder(@RequestBody Order order){
        return new ResponseEntity<>( orderService.save(order),HttpStatus.OK);
    }

    @PutMapping("/{id}/order")
    public ResponseEntity<?> updateUserOrder(@RequestBody Order order, @PathVariable Long id){
        return new ResponseEntity<>(orderService.update(order,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/order")
    public ResponseEntity<?> deleteUserOrder(@PathVariable Long id){
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/order/{orderId}")
    public ResponseEntity<?> addOrderItem(@RequestParam Long itemId, @RequestParam Integer amount, @PathVariable Long id, @PathVariable Long orderId){
        User user = userService.findById(id);
        Order order = orderService.findById(orderId);
        return new ResponseEntity<>(orderService.addItem(itemId, order, amount),HttpStatus.OK);
    }
}