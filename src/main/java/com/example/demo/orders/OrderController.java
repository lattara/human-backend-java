package com.example.demo.orders;

import com.example.demo.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(path= "/orde.rs")
public class OrderController {
    @Autowired OrderRepository orderRepository;
    @Autowired OrderService orderService;

    @GetMapping(path= "/all")
    public @ResponseBody Iterable <Order> getAllOrders (){
        return orderRepository.findAll();
    }

    @GetMapping(path= "/{userId}/all")
    public Iterable <Order> gerOrdersByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping(path="/{userId}/new")
    public void addOrder(@RequestBody Order order, @PathVariable Long userId) {
        orderService.saveOrder(order, userId);
    }

}
