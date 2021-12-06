package com.example.back.controller;


import com.example.back.entity.Result;
import com.example.back.entity.User;
import com.example.back.server.LogininfoService;
import com.example.back.server.UserService;
import com.example.back.server.UsertempService;
import com.example.back.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private LogininfoService logininfoService;
    @Autowired
    UsertempService usertempService;
    @GetMapping("/findAll")
    public Result<List<User>> findAll(){
        return new Result<>(userService.findAll());
    }

    @PostMapping("/login")
    public Result<List<User>> login(HttpServletRequest request)
    {

        String email = request.getParameter("email");
        String pass = request.getParameter("upass");
        if(!userService.existsByEmail(email))
        {
            return new Result<>("该用户不存在", 202);
        }
        List<User> list = userService.findByEmail(email);
        String pas = Md5.md5(pass);
        if(pas==null)
            return new Result<>("输入密码为空", 203);
        if(pas.equals(list.get(0).getUpass())){
            logininfoService.AddLogininfo(request, list.get(0).getUid());
            return new Result<>(list);
        }
        else return new Result<>("密码错误", 201);
    }

    @GetMapping("/findById/{id}")
    public Result<List<User>> findById(@PathVariable("id") Integer id)
    {
        return new Result<>(userService.findById(id));
    }

    @GetMapping("/findByEmail/{email}")
    public Result<List<User>> findByEmail(@PathVariable("email") String email)
    {
        return new Result<>(userService.findByEmail(email));
    }

    @GetMapping("/findByName/{name}")
    public Result<List<User>> findByName(@PathVariable("name") String name)
    {
        return new Result<>(userService.findByName(name));
    }
    @GetMapping("/registerSentEmail/{email}")
    public Result<List<User>> registerSentEmail(@PathVariable("email") String email)
    {
        if(userService.existsByEmail(email))
        {
            return new Result<>("该用户已存在", 203);
        }
        usertempService.register(email);
        return new Result<>("邮件发送成功", 204);
    }

//    @PostMapping("/add")
//    public Result<List<User>> add(HttpServletRequest request)
//    {
//        User user = new User();
//    }
}
