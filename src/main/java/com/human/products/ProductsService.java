package com.human.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

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
}