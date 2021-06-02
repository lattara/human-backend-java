package com.human.orders;

import com.human.users.User;
import com.human.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    //TODO refactor all the DI to inject them trough constructor (preferable way)
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<Orders> getAll(){
        return orderRepository.findAll();
    }

    public Iterable<Orders> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Orders save(Orders orders, Long userId)  {
        User user = userRepository.findById(userId).get();
        orders.setUser(user);
        return orderRepository.save(orders);
    }

    public Optional<Orders> getOne(Long id) {
        return orderRepository.findById(id);
    }

    public void delete(Long orderId) {
        this.orderRepository.deleteById(orderId);
    }

}
