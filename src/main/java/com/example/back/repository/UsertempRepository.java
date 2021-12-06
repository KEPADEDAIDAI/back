package com.example.back.repository;

import com.example.back.entity.Usertemp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsertempRepository extends JpaRepository<Usertemp, Integer> {

    boolean existsUsertempByTmail(String email);
    List<Usertemp> findUsertempByTmail(String email);
}
