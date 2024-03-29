package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dto.UserResponseDTO;
import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.repositories.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.RoleDTO;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.entities.Role;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.RoleRepository;
import com.ecommerce.ecommerce.repositories.UserRepository;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository; // Assuming you have a RoleRepository
    @Autowired
    private CartRepository cartRepository;
    public RoleDTO roleToRoleDTO(Role role) {
   	 RoleDTO role1=new RoleDTO();
   	 role1.setId(role.getId());
   	 role1.setRoleName(role.getRoleName());
   	 return role1;
    }
    public User userDTOToUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);

    }
    public UserResponseDTO userToUserResponseDTO(User user){
        return modelMapper.map(user,UserResponseDTO.class);

    }

    public UserResponseDTO signup(UserDTO userDTO) {
        // Create a new User entity from the DTO
    	
//        User newUser = new User();
        User newUser = userDTOToUser(userDTO);
//        newUser.setUsername(userDTO.getUsername());
//        newUser.setPassword(userDTO.getPassword());
//        newUser.setName(userDTO.getName());


        // Fetch the existing role from the database based on role ID
        Role role = roleRepository.findById(userDTO.getRoleDTO().getId())
                                  .orElseThrow(() -> new RuntimeException("Role not found"));

        // Associate the existing role with the user
        newUser.setRole(role);
        User savedUser = userRepository.save(newUser);
//        /Create a new Cart for the user
        Cart cart = new Cart();
        cart.setUser(savedUser); // Set the user for the cart
        // You may want to set other properties of the cart if needed

        // Save the cart to the database
        cartRepository.save(cart);

        // Set the cart to the user
//        newUser.setCart(cart);

        


//        userDTO.setId(savedUser.getId());

        // Convert the saved user entity back to a DTO
        UserResponseDTO userResponseDTO=userToUserResponseDTO(savedUser);
        userResponseDTO.setRoleDTO(roleToRoleDTO(savedUser.getRole()));

        return new UserResponseDTO(userResponseDTO.getId(), userResponseDTO.getUsername(), userResponseDTO.getName(), userResponseDTO.getRoleDTO());

    }
}
