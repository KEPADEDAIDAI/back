package com.example.back.repository;

import com.example.back.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryReposotory extends JpaRepository<History, Integer> {
//    List<History> findByLid(Integer id);
    List<History> findHistoriesByLid(Integer id);
    List<History> findHistoriesByPid(Integer id);
    List<History> findHistoriesByUid(Integer id);
}
