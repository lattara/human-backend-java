package com.human.orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository <Order, Long> {

   // here we can declare the methods by naming conventions and JPA will look
   //at the name and be able to abstract/ understand what needs to be done
   //naming convention goes like this:
   // find+By+ForeignKeyType(here -> user) + id // findByProperty // Spring JPA will implement it
   // always in camelCase of course!
   public Iterable <Order> findByUserId(Long userId);
}
