package com.example.back.controller;

import com.example.back.entity.History;
import com.example.back.repository.HistoryReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryHandler {
    @Autowired
    private HistoryReposotory historyreposotory;

    @GetMapping("/findAll")
    public List<History> findAll()
    {
        return historyreposotory.findAll();
    }
}
