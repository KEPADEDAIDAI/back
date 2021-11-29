package com.example.back.repository;

import com.example.back.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PicRepository extends JpaRepository<Pic, Integer> {
    List<Pic> getPicByPid(Integer id);
}
