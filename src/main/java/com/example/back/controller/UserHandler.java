package com.example.back.controller;


import com.example.back.entity.Result;
import com.example.back.entity.User;
import com.example.back.repository.UserReponsitory;
import com.example.back.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public Result<List<User>> findAll(){
        return new Result<>(userService.findAll());
    }
}
