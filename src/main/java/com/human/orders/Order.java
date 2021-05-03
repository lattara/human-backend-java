package com.human.orders;

import com.human.products.Product;
import com.human.users.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne (cascade = CascadeType.PERSIST) //  JPA annotation that hibernate interprets
    private User user;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Order () {
    }

    public Order(User user){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(Product productToAdd) {
        products.add(productToAdd);
    }
}
