package com.example.back.repository;

import com.example.back.entity.User;
import com.example.back.utils.Md5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserReponsitoryTest {

    @Autowired
    private UserReponsitory userReponsitory;
//
//    @Test
//    void findAll(){System.out.println(userReponsitory.findAll());}

//    @Test
//    void UserSave()
//    {
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        User user = new User();
//        user.setEmail("123@456");
//        String pas = Md5.md5("123456");
//        user.setUpass(pas);
//        user.setRepasstime(sdf.format(d));
//        user.setUname("123@456");
//        user.setPhone("17916892094");
//
//        userReponsitory.save(user);
//    }
}