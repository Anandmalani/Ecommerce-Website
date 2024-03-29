package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}

