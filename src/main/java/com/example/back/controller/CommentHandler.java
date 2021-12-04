package com.example.back.controller;


import com.example.back.entity.Comment;
import com.example.back.entity.Result;
import com.example.back.repository.CommentRepository;
import com.example.back.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    private CommentService commentService;

    @GetMapping("/findAll")
    public Result<List<Comment>> findAll()
    {
        return new Result<>(commentService.findAll());
    }

    @GetMapping("/findByPid/{id}")
    public Result<List<Comment>> findByPid(@PathVariable("id") Integer id)
    {
        return new Result<>(commentService.getCommentByPid(id));
    }

    @GetMapping("/findByUid/{id}")
    public Result<List<Comment>> findByUid(@PathVariable("id") Integer id)
    {
        return new Result<>(commentService.getCommentByPid(id));
    }
}
