package com.example.demo.orders;

import com.example.demo.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired OrderRepository orderRepository;
    @Autowired UserRepository userRepository;
    // getall
    //get all from specific user
    //get one from specific user

    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Iterable<Order> getOrdersByUserId(Long userId) {
        System.out.println("repository called");
        return orderRepository.findByUserId(userId);
    }

    public Order saveOrder(Order order, Long userId)  {
        order.setUser(userRepository.findById(userId).get());
        return orderRepository.save(order);
    }

}
