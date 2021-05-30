package com.human.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")

public class OrderController {

    // here Ana check difference between @Autowired and constructor injection
    @Autowired OrderService orderService;

    @GetMapping("")
    public @ResponseBody Iterable <Order> getAllOrders (){
        return orderService.getAll();
    }

    @GetMapping("/{userId}")
    public Iterable <Order> gerOrdersByUserId(@PathVariable Long userId){
        return orderService.getByUserId(userId);
    }

    @PostMapping("/{userId}")
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
