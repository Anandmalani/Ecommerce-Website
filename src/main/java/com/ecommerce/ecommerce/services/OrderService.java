package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.CartItem;
import com.ecommerce.ecommerce.entities.Order1;
import com.ecommerce.ecommerce.entities.User;
import com.ecommerce.ecommerce.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public void placeOrder(Long id) {
        User user=userRepository.findById(id).get();
        // Fetch cart items for the user

        Cart cart = cartRepository.findByUser(user);
        List<CartItem> cartItems = cartItemRepository.findByCart(cart);
//        if (cartItems.isEmpty()) {
//            throw new RuntimeException("Cart is empty");
//        }
        // Create a new order
        Order1 order = new Order1();
        order.setUserId(id);

//        order.setUser(user);
//        order.setUser();
        order.setTotalAmount(cart.getTotalAmount());
        // Save order to database
        Order1 savedOrder = orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);

        // Optional: You might want to reset the total amount in the cart after placing the order
//        cart.setTotalAmount(0L);
//        cartRepository.save(cart);


    }


}
