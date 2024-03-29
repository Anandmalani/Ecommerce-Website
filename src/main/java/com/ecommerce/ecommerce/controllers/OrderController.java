package com.ecommerce.ecommerce.controllers;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order/{id}")
    public ResponseEntity<String> placeOrder(@PathVariable Long id) {
        try {
            orderService.placeOrder(id);
            return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to place order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
