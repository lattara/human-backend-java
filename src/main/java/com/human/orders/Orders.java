package com.human.orders;

import com.human.Address;
import com.human.products.Product;
import com.human.users.User;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="created")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "is_sent")
    private Boolean isSent;

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private User user;

    @OneToOne
    private Address dispatchAddress;

    @OneToMany
    private List<Product> products = new ArrayList<>();


    public Orders() {
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
        return isSent;
    }

    public void setIs_sent(Boolean isSent) {
        this.isSent = isSent;
    }
}
