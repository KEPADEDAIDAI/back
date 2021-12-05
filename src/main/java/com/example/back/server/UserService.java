package com.example.back.server;

import com.example.back.entity.User;
import com.example.back.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public List<User> findAll()
    {
        return userReponsitory.findAll();
    }

    public List<User> findByName(String name)
    {
        return userReponsitory.findUserByUname(name);
    }

    public boolean existsByName(String name){
        return userReponsitory.existsByUname(name);
    }
}
