package com.example.back.server;

import com.example.back.entity.History;
import com.example.back.repository.HistoryReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryReposotory historyReposotory;

    public List<History> findAll() {
        return historyReposotory.findAll();
    }

    public List<History> findByUid(Integer id) {
        return historyReposotory.findHistoriesByUid(id);
    }

    public List<History> findByPid(Integer id) {
        return historyReposotory.findHistoriesByPid(id);
    }
    public List<History> findByLid(Integer id){
        return historyReposotory.findHistoriesByLid(id);
    }
    public List<History> SaveHistory(History history)
    {
        List<History> list = new ArrayList<>();
        list.add(historyReposotory.save(history));
        return list;
    }
}
