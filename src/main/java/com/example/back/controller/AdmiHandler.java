package com.example.back.controller;

import com.example.back.entity.Admi;
import com.example.back.repository.AdmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admi")
public class AdmiHandler {
    @Autowired
    private AdmiRepository admiRepository;

    @GetMapping("/findAll")
    public List<Admi> findAll(){
        return admiRepository.findAll();
    }
}
