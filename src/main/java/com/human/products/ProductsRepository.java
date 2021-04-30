package com.human.products;

import com.human.HibernateConn;
import com.human.orders.Order;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository <Product, Long> {

    @Query(value = "SELECT * FROM products WHERE is_sold = 1", nativeQuery = true)
    Iterable<Product> getUnsold();

    @Query(value = "SELECT * FROM products WHERE is_sold = 0", nativeQuery = true)
    Iterable<Product> getSold();

}
