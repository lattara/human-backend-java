package com.human.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    // here Ana check difference between @Autowired and constructor injection
    @Autowired
    ProductsService productsService;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Product> getAllProducts () {
        return productsService.getAll();
    }

    @GetMapping("/unsold")
    public @ResponseBody
    Iterable<Product> getAllUnsold() {
        return productsService.getUnsold();
    }

    @GetMapping("/sold")
    public @ResponseBody
    Iterable<Product> getAllSold() {
        return productsService.getSold();
    }

    @GetMapping("/{id}")
    public Product gerProductById(@PathVariable Long productId){
        return productsService.getOne(productId).get();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long orderId){
        productsService.delete(orderId);
    }

    @PatchMapping("/{id}")
    public Product editProduct( @RequestBody Product product, @PathVariable Long productId) {
        return this.productsService.update(product, productId);
    }


}
