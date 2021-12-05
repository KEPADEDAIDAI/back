package com.example.back.repository;

import com.example.back.entity.Tes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesRepository extends JpaRepository<Tes, Integer> {

    void deleteById(Integer id);
}
