package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.dto.CartItemDTO;
import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long userId, @RequestBody CartItemDTO cartItemDTO) {
        Cart cart = cartService.addToCart(userId, cartItemDTO);
        return ResponseEntity.ok(cart);
    }

//    @DeleteMapping("/remove/{cartItemId}")
//    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartItemId) {
//        cartService.removeFromCart(cartItemId);
//        return ResponseEntity.ok().build();
//    }
}
