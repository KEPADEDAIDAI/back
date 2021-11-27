package com.example.back.controller;


import com.example.back.entity.Comment;
import com.example.back.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/findAll")
    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }

}
