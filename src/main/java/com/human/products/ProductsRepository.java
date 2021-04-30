package com.human.products;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository <Product, Long> {

    Session session =
    public static Iterable<Product> getUnsold() {
        Query query = session.createQuery
    }
}
