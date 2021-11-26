package com.example.back.repository;

import com.example.back.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicRepository extends JpaRepository<Pic, Integer> {

}
