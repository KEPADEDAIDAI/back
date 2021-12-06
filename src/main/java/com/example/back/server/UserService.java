package com.example.back.server;

import com.example.back.entity.User;
import com.example.back.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String address, String code)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("民族图像展馆注册验证码");
        message.setFrom("kepadedaidai@163.com");
        message.setTo(address);
        message.setSentDate(new Date());
        message.setText("您的验证码是 " + code + " 验证码10分钟内有效,如果这不是您的操作，请忽略这封邮件");
        javaMailSender.send(message);
    }
    public List<User> findAll() {
        return userReponsitory.findAll();
    }

    public List<User> findByName(String name) {
        return userReponsitory.findUserByUname(name);
    }
    public List<User> findByEmail(String Email) {
        return userReponsitory.findUserByEmail(Email);
    }
    public List<User> findById(Integer id)
    {
        return userReponsitory.findUserByUid(id);
    }
    public boolean existsByName(String name) {
        return userReponsitory.existsByUname(name);
    }

    public boolean existsByUid(Integer id) {
        return userReponsitory.existsByUid(id);
    }

    public boolean existsByEmail(String Email) {
        return userReponsitory.existsByEmail(Email);
    }


}
