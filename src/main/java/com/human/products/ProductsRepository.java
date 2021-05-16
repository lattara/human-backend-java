package com.human.products;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE is_sold = 1", nativeQuery = true)
    Iterable<Product> getUnsold();

    @Query(value = "SELECT * FROM products WHERE is_sold = 0", nativeQuery = true)
    Iterable<Product> getSold();


}
