package com.human.products;


import com.human.orders.Orders;
import com.human.orders.OrderRepository;
import com.human.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    public Iterable<Product> getAll(Integer pageNo, Integer pageSize, String sortBy, String sortType) {
        Sort.Direction direction = Sort.Direction.fromString(sortType);
        return productsRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(direction, sortBy)));
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

    public void addToOrder(Long productId, Long orderId) {
            //order id already exists so just add a product to it
            Orders currentOrders = orderRepository.findById(orderId).get();
            currentOrders.setProduct(productsRepository.findById(productId).get());
            orderRepository.save(currentOrders);
    }

    public void createOrderAndAddProduct(Long productId) {
        // TODO implement method to get current user and create new order for that user but for now hardcoded user to test the route
        Orders newOrders = new Orders();
        newOrders.setUser(userRepository.findById((long) 6).get());
        newOrders.setProduct(productsRepository.findById(productId).get());
        orderRepository.save(newOrders);
    }

    public Iterable<Product> getAllWithFilter(List queryParams){
        System.out.println("queryParams" + queryParams);
        return productsRepository.findAll();
    }


}