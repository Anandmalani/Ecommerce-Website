package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

	private Long id;
    private String username;
    
//    @JsonIgnore
    private String password; // Exclude password from serialization
    
    private String name;
    private RoleDTO roleDTO;


    

    // Constructors, getters, setters
}

