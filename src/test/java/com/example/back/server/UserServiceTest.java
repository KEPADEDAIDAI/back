package com.example.back.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
//    @Test
//    void sendEmail() {
//        String address = "sunabrhh@foxmail.com", code = "123456";
//        userService.sendEmail(address,code);
//        System.out.println("finish");
//    }
}