package com.example.back.server;

import com.example.back.entity.Comment;
import com.example.back.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }
}
