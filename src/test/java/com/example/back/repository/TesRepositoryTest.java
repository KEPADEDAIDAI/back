package com.example.back.repository;

import com.example.back.entity.Tes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TesRepositoryTest {
    @Autowired
    private TesRepository tesRepository;

//    @Test
//    public void TesSave()
//    {
//        Tes tes = new Tes();
//        tes.setTxt("sixth");
//        System.out.println(tesRepository.saveAndFlush(tes));
//
//    }

}