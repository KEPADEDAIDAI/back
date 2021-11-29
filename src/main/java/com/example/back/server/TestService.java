package com.example.back.server;

import com.example.back.entity.Test;
import com.example.back.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List<Test> findAll(){
        return testRepository.findAll();
    }
}
