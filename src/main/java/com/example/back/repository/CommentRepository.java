package com.example.back.repository;

import com.example.back.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getCommentsByPid(Integer id);
    List<Comment> getCommentsByUid(Integer id);
    boolean existsCommentByPid(Integer id);
    boolean existsCommentByUid(Integer id);
}
