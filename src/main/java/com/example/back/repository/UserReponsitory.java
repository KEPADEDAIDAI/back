package com.example.back.repository;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserReponsitory extends JpaRepository<User, Integer> {



    boolean existsUserByUid(Integer id);

    boolean existsUserByEmail(String email);
    List<User> findUserByUname(String name);
    List<User> findUsersByEmail(String email);
    List<User> findUserByUid(Integer uid);

    boolean existsUserByUname(String name);

    @Transactional
    void deleteUserByUid(Integer uid);
}
