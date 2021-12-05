package com.example.back.controller;


import com.example.back.entity.Result;
import com.example.back.entity.User;
import com.example.back.repository.UserReponsitory;
import com.example.back.server.UserService;
import com.example.back.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/login/{uname}/{pass}")
    public Result<List<User>> login(@PathVariable("uname") String uname, @PathVariable("pass") String pass)
    {
        if(!userService.existsByName(uname))
        {
            return new Result<>("该用户不存在", 202);
        }
        List<User> list = userService.findByName(uname);
        String pas = Md5.md5(pass);
        if(pas==null)
            return new Result<>("输入密码为空", 203);
        if(pas.equals(list.get(0).getUpass())){
            return new Result<>(list);
        }
        else return new Result<>("密码错误", 201);
    }
}
