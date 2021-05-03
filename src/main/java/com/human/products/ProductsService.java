package com.human.products;

import com.human.orders.Order;
import com.human.orders.OrderRepository;
import com.human.users.User;
import com.human.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public Iterable<Product> getAll(){
        return productsRepository.findAll();
    }

    public Iterable<Product> getUnsold() { return productsRepository.getUnsold(); }

    public Iterable<Product> getSold() { return productsRepository.getSold(); }

    public Optional<Product> getOne(Long id) {
        return productsRepository.findById(id);
    }

    public Product save(Product product)  { return productsRepository.save(product); }

    public void delete(Long orderId) {
        productsRepository.deleteById(orderId);
    }

    public Product update(Product product, Long productId) {
        product.setId(productId);
        return productsRepository.save(product);
    }

    public void addToCart(Long productId, Long orderId) {
            //order id already exists so just add a product to it
            Order currentOrder = orderRepository.findById(orderId).get();
            currentOrder.setProduct(productsRepository.findById(productId).get());
            orderRepository.save(currentOrder);
    }
}