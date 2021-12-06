package com.example.back.controller;


import com.example.back.entity.Comment;
import com.example.back.entity.Result;
import com.example.back.repository.CommentRepository;
import com.example.back.server.CommentService;
import com.example.back.server.PicService;
import com.example.back.server.UserService;
import com.example.back.utils.checkInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private PicService picService;
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
        return new Result<>(commentService.getCommentByUid(id));
    }

    @PostMapping("/addComment")
    public Result<List<Comment>> addComment(HttpServletRequest httpServletRequest){
        Comment comment = new Comment();
        String pid = httpServletRequest.getParameter("pid");
        String uid = httpServletRequest.getParameter("uid");
        if(!checkInt.check(pid))
        {
            return new Result<>("图片id不是整数",301);
        }
        if(!checkInt.check(uid)){
            return new Result<>("用户id不是整数",302);
        }
        comment.setPid(Integer.valueOf(pid));
        comment.setUid(Integer.valueOf(uid));
        if(!picService.existsByPid(comment.getPid()))
        {
            return new Result<>("传入图片不存在", 303);
        }
        if(!userService.existsByUid(comment.getUid())){
            return new Result<>("传入用户不存在", 304);
        }
        comment.setPltxt(httpServletRequest.getParameter("pltxt"));
        if(comment.getPltxt()==null)
        {
            return new Result<>("传入评论内容为空", 305);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setPltime(sdf.format(new Date()));
        return new Result<>(commentService.SaveComment(comment));
    }
}
