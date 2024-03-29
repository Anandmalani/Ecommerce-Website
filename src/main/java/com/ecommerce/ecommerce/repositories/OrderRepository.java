package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Long> {
    // You can add custom query methods if needed
}

