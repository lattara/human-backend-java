package com.human.users;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface UserRepository extends CrudRepository <User, Long>, JpaRepository <User, Long> {

    Optional<User> findByUserName(String userName);

    boolean existsByEmail(String email);
}

