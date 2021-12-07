package com.example.back.controller;


import com.example.back.entity.Result;
import com.example.back.entity.User;
import com.example.back.entity.Usertemp;
import com.example.back.entity.request.LoginRequest;
import com.example.back.server.LogininfoService;
import com.example.back.server.UserService;
import com.example.back.server.UsertempService;
import com.example.back.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    public Result<List<User>> login(HttpServletRequest request, @RequestBody LoginRequest loginRequest)
    {
        if(!userService.existsByEmail(loginRequest.getEmail()))
        {
            return new Result<>("该用户不存在", 202);
        }
        List<User> list = userService.findByEmail(loginRequest.getEmail());
        String pas = Md5.md5(loginRequest.getUpass());
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
        return new Result<>("success", 1);
    }
    @GetMapping("/resetPassSentEmail/{email}")
    public Result<List<User>> resetPassSentEmail(@PathVariable("email") String email)
    {
        if(!userService.existsByEmail(email)) return new Result<>("该用户不存在", 212);
        userService.resetPassEmail(email);
        return new Result<>("success", 1);
    }
    @PostMapping("/add")
    public Result<List<User>> add(HttpServletRequest request)
    {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        if(userService.existsByEmail(user.getEmail()))
        {
            return new Result<>("该用户邮箱已存在",205);
        }
        if(!usertempService.existsByEmail(user.getEmail()))
        {
            return new Result<>("该用户还没发注册邮件，请先发注册邮件",206);
        }
        long now = new Date().getTime();
        String tempCode = request.getParameter("tempcode");
        Usertemp tmp = usertempService.findByEmail(user.getEmail()).get(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date ned = sdf.parse(tmp.getTtime());
            long need = ned.getTime();
            if(now > need)
            {
                return new Result<>("验证码已过期", 207);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!tempCode.equals(tmp.getTcode()))
        {
            return new Result<>("验证码错误",208);
        }
        String pas = request.getParameter("upass");
        if(pas==null)
        {
            return new Result<>("密码为空",209);
        }
        user.setUpass(Md5.md5(pas));
        user.setUname(request.getParameter("uname"));
        if(user.getUname()==null) user.setUname(user.getEmail());
        user.setRepasstime(sdf.format(new Date()));
        user.setPhone(request.getParameter("phone"));
        return new Result<>(userService.SaveUser(user));
    }
    @GetMapping("/del/{uid}")
    public Result<List<User>> del(@PathVariable("uid") Integer uid)
    {
        if(!userService.existsByUid(uid))
        {
            return new Result<>("该用户不存在", 210);
        }
        userService.del(uid);
        return new Result<>("success", 1);
    }
    @PostMapping("/resetInfo")
    public Result<List<User>> resetInfo(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        if(!userService.existsByEmail(email))
        {
            return new Result<>("用户不存在", 211);
        }
        User user = userService.findByEmail(email).get(0);
        String uname = request.getParameter("uname");
        if(uname!=null) user.setUname(uname);
        String phone = request.getParameter("phone");
        if(phone != null) user.setPhone(phone);
        return  new Result<>(userService.SaveUser(user));
    }
    @PostMapping("/resetPass")
    public Result<List<User>> resetPass(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        if(!userService.existsByEmail(email)) return new Result<>("该用户不存在", 212);
        User user = userService.findByEmail("email").get(0);
        String tempCode = request.getParameter("repass");
        long now = new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date ned = sdf.parse(user.getRepasstime());
            long need = ned.getTime();
            if(now > need)
            {
                return new Result<>("验证码已过期", 207);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!Objects.equals(tempCode, user.getRepass()))
            return new Result<>("验证码错误", 208);
        String pass = request.getParameter("upass");
        if(pass==null)
            return new Result<>("密码为空", 209);
        user.setUpass(Md5.md5(pass));
        return new Result<>(userService.SaveUser(user));
    }
}
