package com.human.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public Iterable<Product> getAll(){
        return productsRepository.findAll();
    }

    public Iterable<Product> getUnsold(){
        return productsRepository.getUnsold();
    }

    public Product save(Product product)  { return productsRepository.save(product);
    }
    public Optional<Product> getOne(Long id) {
        return productsRepository.findById(id);
    }

    public void delete(Long orderId) {
        this.productsRepository.deleteById(orderId);
    }

}