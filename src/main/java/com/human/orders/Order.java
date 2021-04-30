package com.human.orders;

import com.human.users.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne (cascade = CascadeType.PERSIST) // this is just an JPA annotation / javax.persistence
    private User user;

    public Order(){
    }

    public Order(Long id, Date date, Long userId) {
        this.id = id;
        this.date = date;
        this.user = new User(userId, "", "", "");
    }

    public Order(Order order, User user) {
        this.date = order.date;
        this.user = user;
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

    @Override
    public String toString() {
        return "Order [id=" + id + ", date=" + date +
                ", user=" + user + "]";
    }

}
