package com.example.back.server;

import com.example.back.entity.Comment;
import com.example.back.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentByPid(Integer id){ return commentRepository.getCommentsByPid(id);}

    public List<Comment> getCommentByUid(Integer id) { return commentRepository.getCommentsByUid(id);}

    public List<Comment> SaveComment(Comment comment)
    {
        List<Comment> list = new ArrayList<>();
        list.add(commentRepository.save(comment));
        return list;
    }

    public boolean existsByPid(Integer id) {
        return commentRepository.existsCommentByPid(id);
    }
    public boolean existsByUid(Integer id)
    {
        return commentRepository.existsCommentByUid(id);
    }
}
