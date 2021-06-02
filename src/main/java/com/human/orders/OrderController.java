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
    public @ResponseBody Iterable <Orders> getAllOrders (){
        return orderService.getAll();
    }

    @GetMapping("/{userId}")
    public Iterable <Orders> gerOrdersByUserId(@PathVariable Long userId){
        return orderService.getByUserId(userId);
    }

    @PostMapping("/{userId}")
    public void addOrder(@RequestBody Orders orders, @PathVariable Long userId) {
        orderService.save(orders, userId);
    }

    @GetMapping("/{userId}/{orderId}")
    public Optional<Orders> getSpecificOrder(@PathVariable Long orderId){
        return orderService.getOne(orderId);
    }

    @DeleteMapping("/{userId}/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderService.delete(orderId);
    }

}
