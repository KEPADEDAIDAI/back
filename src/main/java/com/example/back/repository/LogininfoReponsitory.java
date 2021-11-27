package com.example.back.repository;

import com.example.back.entity.Logininfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogininfoReponsitory extends JpaRepository<Logininfo, Integer> {
}
