package com.ouhamza.demo.dao;

import com.ouhamza.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author Lhouceine OUHAMZA
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Stream<User> findAllByActiveTrue();
}
