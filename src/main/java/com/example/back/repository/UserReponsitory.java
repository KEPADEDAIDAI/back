package com.example.back.repository;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<User, Integer> {

}
