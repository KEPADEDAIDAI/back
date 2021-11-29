package com.example.back.server;

import com.example.back.entity.Pic;
import com.example.back.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {
    @Autowired
    PicRepository picRepository;

    public List<Pic> findById(Integer id)//按照id查找
    {
        return picRepository.getPicByPid(id);
    }
    public List<Pic> findAll()
    {
        return picRepository.findAll();
    }
}
