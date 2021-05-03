package com.human.Cart;

import com.human.orders.OrderRepository;
import com.human.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



    @Service
    public class CartService {

        @Autowired
        private OrderRepository orderRepository;
        @Autowired
        private UserRepository userRepository;

        // user is connected and has and order





}

