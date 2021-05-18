package com.human.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE is_sold = 1", nativeQuery = true)
    Iterable<Product> getUnsold();

    @Query(value = "SELECT * FROM products WHERE is_sold = 0", nativeQuery = true)
    Iterable<Product> getSold();


}
