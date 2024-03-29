package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dto.CartItemDTO;
import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.CartItem;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.CartItemRepository;
import com.ecommerce.ecommerce.repositories.CartRepository;
import com.ecommerce.ecommerce.repositories.ProductRepository;
import com.ecommerce.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart addToCart(Long userId, CartItemDTO cartItemDTO) {
        // Retrieve or create cart based on userId
        Cart cart = cartRepository.findByUserId(userId);
//        if (cart == null) {
//            cart = new Cart();
//            User user=userRepository.findById(userId).get();
//            cart.setUser(user);
////            cart.setUserId(userId);
//            cart.setTotalAmount(0L);
//            cart = cartRepository.save(cart);
//        }

        // Check if item already exists in cart
        CartItem cartItem = cartItemRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), cartItemDTO.getProductId());

//        CartItem cartItem = cartItemRepository.findByCartAndProduct(cart.getCartId(), cartItemDTO.getProductId());
        if (cartItem != null) {
            // If item exists, update quantity
            cartItem.setQuantity(cartItem.getQuantity() + cartItemDTO.getQuantity());
        } else {
            // If item doesn't exist, create new cart item
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setQuantity(cartItemDTO.getQuantity());
            Product product=productRepository.findById(cartItemDTO.getProductId()).get();
            cartItem.setProduct(product);
        }

        // Save/update cart item
        cartItemRepository.save(cartItem);

        // Update total amount in cart
        updateCartTotalAmount(cart);

        return cart;
    }

//    public void removeFromCart(Long cartItemId) {
//        // Find and delete cart item by id
//        cartItemRepository.deleteById(cartItemId);
//
//        // Update total amount in cart
//        // Fetch cart based on cartItemId
//        Cart cart = cartRepository.findByCartItemId(cartItemId);
//        if (cart != null) {
//            updateCartTotalAmount(cart);
//        }
//    }

    private void updateCartTotalAmount(Cart cart) {
        // Calculate total amount of cart items and update in cart entity
        Long totalAmount = cartItemRepository.getTotalAmountByCart(cart.getCartId());
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }
}

