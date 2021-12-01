package com.example.back.server;

import com.example.back.entity.Admi;
import com.example.back.repository.AdmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmiService {
    @Autowired
    private AdmiRepository admiRepository;

    public List<Admi> findAll()
    {
        return admiRepository.findAll();
    }
}
