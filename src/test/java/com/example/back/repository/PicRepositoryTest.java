package com.example.back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PicRepositoryTest {

    @Autowired
    private PicRepository picRepository;
    @Test
    void findAll(){
        System.out.println(picRepository.findAll());
    }

    @Test
    void getPicsByTime()
    {
        System.out.println(picRepository.getPicsByTime("2021-11-19", "2021-11-19"));
    }
}