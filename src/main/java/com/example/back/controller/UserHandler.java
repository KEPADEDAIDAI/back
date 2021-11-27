package com.example.back.controller;


import com.example.back.entity.User;
import com.example.back.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserReponsitory userReponsitory;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userReponsitory.findAll();
    }
}
