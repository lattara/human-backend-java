package com.human.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")

public class OrderController {

    // here Ana check difference between @Autowired and constructor injection
    @Autowired OrderRepository orderRepository;
    @Autowired OrderService orderService;

    @GetMapping("/all")
    public @ResponseBody Iterable <Order> getAllOrders (){
        return orderRepository.findAll();
    }

    @GetMapping("/{userId}/all")
    public Iterable <Order> gerOrdersByUserId(@PathVariable Long userId){
        return orderService.getByUserId(userId);
    }

    @PostMapping("/{userId}/new")
    public void addOrder(@RequestBody Order order, @PathVariable Long userId) {
        orderService.save(order, userId);
    }

    @GetMapping("/{userId}/{orderId}")
    public Optional<Order> getSpecificOrder(@PathVariable Long orderId){
        return orderService.getOne(orderId);
    }

    @DeleteMapping("/{userId}/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderService.delete(orderId);
    }

}
