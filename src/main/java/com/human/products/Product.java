package com.human.products;

import com.human.utils.ProductCategory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="Products")

public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name="description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="is_sold")
    private boolean isSold = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 8)
    private ProductCategory category;



    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
