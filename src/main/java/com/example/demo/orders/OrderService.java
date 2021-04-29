package com.example.demo.orders;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService (OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Iterable<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order saveOrder(Order order, Long userId)  {
        Iterable<User> userArrayList = userRepository.findAll();

        Optional<User> user = userRepository.findById(userId);
        order.setUser(user.get());
        return orderRepository.save(order);
    }

}
