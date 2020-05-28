package com.ouhamza.demo.dao;

import com.ouhamza.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author Lhouceine OUHAMZA
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Stream<Order> findByActiveTrue();
}
