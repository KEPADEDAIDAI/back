package com.example.back.controller;

import com.example.back.entity.History;
import com.example.back.entity.Result;
import com.example.back.repository.HistoryReposotory;
import com.example.back.server.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryHandler {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/findAll")
    public Result<List<History>> findAll()
    {
        return new Result<>(historyService.findAll());
    }
}
