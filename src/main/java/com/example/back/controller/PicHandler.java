package com.example.back.controller;

import com.example.back.entity.Pic;
import com.example.back.entity.Result;
import com.example.back.repository.PicRepository;
import com.example.back.server.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pic")
public class PicHandler {
    @Autowired
    private PicRepository picRepository;

    @Autowired
    private PicService picService;
    @GetMapping("/findAll")
    public Result<List<Pic>> findAll()
    {
        return new Result<>(picService.findAll());
    }
    @GetMapping("/findById/{id}")
    public Result<List<Pic>>findById(@PathVariable("id") Integer id)
    {
//        System.out.println("id="+id);
        return new Result<>(picService.findById(id));
    }
}
