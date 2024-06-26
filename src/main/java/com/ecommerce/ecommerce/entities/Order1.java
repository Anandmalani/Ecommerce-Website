package com.ecommerce.ecommerce.entities;

import com.ecommerce.ecommerce.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    private Long totalAmount;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    private Long userId;




    
    

    // Constructors, getters, and setters
}

