package com.example.back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestRepositoryTest {

    @Autowired
    private TestRepository testRepository;
    @Test
    void findAll(){
        System.out.println(testRepository.findAll());
    }
}