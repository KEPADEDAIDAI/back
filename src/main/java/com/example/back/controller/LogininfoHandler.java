package com.example.back.controller;

import com.example.back.entity.Logininfo;
import com.example.back.entity.Result;
import com.example.back.repository.LogininfoReponsitory;
import com.example.back.server.LogininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logininfo")
public class LogininfoHandler {
    @Autowired
    private LogininfoService logininfoService;

    @GetMapping("/findAll")
    public Result<List<Logininfo>> findAll()
    {
        return new Result<>(logininfoService.findAll());
    }
}
