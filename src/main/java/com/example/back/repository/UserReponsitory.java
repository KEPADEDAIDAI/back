package com.example.back.repository;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReponsitory extends JpaRepository<User, Integer> {


    boolean existsByUname(String name);

    boolean existsByUid(Integer id);

    boolean existsByEmail(String email);
    List<User> findUserByUname(String name);
    List<User> findUserByEmail(String email);
    List<User> findUserByUid(Integer uid);
}
