package com.example.myhome.repository;

import com.example.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = { "boards" })  // 여러개의 쿼리를 하나로
    List<User> findAll();

    User findByUsername(String username);
}
