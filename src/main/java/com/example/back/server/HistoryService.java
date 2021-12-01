package com.example.back.server;

import com.example.back.entity.History;
import com.example.back.repository.HistoryReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryReposotory historyReposotory;

    public List<History> findAll()
    {
        return historyReposotory.findAll();
    }
}
