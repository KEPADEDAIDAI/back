package com.example.back.repository;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReponsitory extends JpaRepository<User, Integer> {
    List<User> findUserByUname(String name);

    boolean existsByUname(String name);

}
