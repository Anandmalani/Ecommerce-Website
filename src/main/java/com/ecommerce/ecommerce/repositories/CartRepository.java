package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.CartItem;
import com.ecommerce.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);

    Cart findByUser(User user);
}

