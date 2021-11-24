package com.example.back.controller;

import com.example.back.entity.Test;
import com.example.back.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestHandler {


    @Autowired
    private TestRepository testRepository;

    @GetMapping("/findAll")
    public List<Test> findAll(){
        return testRepository.findAll();
    }
}
