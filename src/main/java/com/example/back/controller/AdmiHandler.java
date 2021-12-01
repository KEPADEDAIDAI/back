package com.example.back.controller;

import com.example.back.entity.Admi;
import com.example.back.entity.Result;
import com.example.back.repository.AdmiRepository;
import com.example.back.server.AdmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admi")
public class AdmiHandler {
    @Autowired
    private AdmiService admiService;

    @GetMapping("/findAll")
    public Result<List<Admi>> findAll() {
        return new Result<>(admiService.findAll());
    }
}
