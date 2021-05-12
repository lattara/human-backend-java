package com.human.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId){
        return productsService.getOne(productId).get();
    }

    @PostMapping("/new")
    public @ResponseBody
    Product saveProduct (@RequestBody Product product) { return productsService.save(product); }

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

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productsService.delete(productId);
    }

    @PatchMapping("/{productId}")
    public Product editProduct( @RequestBody Product product, @PathVariable Long productId) {
        return productsService.update(product, productId);
    }

    @PostMapping("/{productId}/{orderId}/addToCart")
    public void addToExistingOrder(@PathVariable Long productId, @PathVariable Long orderId) {
            this.productsService.addToOrder(productId, orderId);
    }

    @PostMapping("/{productId}/addToCart")
    public void addToNewChart(@PathVariable Long productId, @RequestParam(name="orderId", required=false) Long orderId) {
            productsService.createOrderAndAddProduct(productId);
    }

}
