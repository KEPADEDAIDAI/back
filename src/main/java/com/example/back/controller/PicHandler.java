package com.example.back.controller;

import com.example.back.entity.Pic;
import com.example.back.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pic")
public class PicHandler {
    @Autowired
    private PicRepository picRepository;

    @GetMapping("/findAll")
    public List<Pic> findAll(){
        return picRepository.findAll();
    }

}
