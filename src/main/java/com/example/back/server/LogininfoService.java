package com.example.back.server;

import com.example.back.entity.Logininfo;
import com.example.back.repository.LogininfoReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogininfoService {
    @Autowired
    private LogininfoReponsitory logininfoReponsitory;

    public List<Logininfo> findAll()
    {
        return logininfoReponsitory.findAll();
    }
}
