package com.example.back.repository;

import com.example.back.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryReposotory extends JpaRepository<History, Integer> {
}
