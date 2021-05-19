package com.human.orders;

import com.human.products.Product;
import com.human.users.User;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Sort;

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

    @ManyToOne (cascade = CascadeType.PERSIST)
    private User user;

    private Boolean is_sent;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Order () {
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

    public Boolean getIs_sent() {
        return is_sent;
    }

    public void setIs_sent(Boolean is_sent) {
        this.is_sent = is_sent;
    }
}
