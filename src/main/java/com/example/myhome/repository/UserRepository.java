package com.example.myhome.repository;

import com.example.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, CustomizedUserRepository {
    @EntityGraph(attributePaths = { "boards" })  // 여러개의 쿼리를 하나로
    List<User> findAll();

    User findByUsername(String username);

    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameQuery(String username);

    @Query(value = "select * from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);
}
