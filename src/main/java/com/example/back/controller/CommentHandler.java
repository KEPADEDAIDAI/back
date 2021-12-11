package com.example.back.controller;


import com.example.back.entity.Comment;
import com.example.back.entity.Result;
import com.example.back.request.AddCommentRequest;
import com.example.back.request.CommentFindRequest;
import com.example.back.server.CommentService;
import com.example.back.server.PicService;
import com.example.back.server.UserService;
import com.example.back.utils.checkInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    public Result<List<Comment>> findAll() {
        return new Result<>(commentService.findAll());
    }

    @GetMapping("/findByPid/{id}")
    public Result<List<Comment>> findByPid(@PathVariable("id") Integer id) {
        return new Result<>(commentService.getCommentByPid(id));
    }

    @GetMapping("/findByUid/{id}")
    public Result<List<Comment>> findByUid(@PathVariable("id") Integer id) {
        return new Result<>(commentService.getCommentByUid(id));
    }

    @PostMapping("/addComment")
    public Result<List<Comment>> addComment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        String pid = addCommentRequest.getPid();
        String uid = addCommentRequest.getUid();
        if (!checkInt.check(pid)) {
            return new Result<>("图片id不是整数", 301);
        }
        if (!checkInt.check(uid)) {
            return new Result<>("用户id不是整数", 302);
        }
        comment.setPid(Integer.valueOf(pid));
        comment.setUid(Integer.valueOf(uid));
        if (!picService.existsByPid(comment.getPid())) {
            return new Result<>("传入图片不存在", 303);
        }
        if (userService.existsByUid(comment.getUid())) {
            return new Result<>("传入用户不存在", 304);
        }
        comment.setPltxt(addCommentRequest.getPltxt());
        if (comment.getPltxt() == null) {
            return new Result<>("传入评论内容为空", 305);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setPltime(sdf.format(new Date()));
        return new Result<>(commentService.SaveComment(comment));
    }

    @PostMapping("/findAllPages")
    public Result<List<Comment>> findAllPages(@RequestBody CommentFindRequest commentFindRequest) {
        String pageSize = commentFindRequest.getPageSize();
        String pageNo = commentFindRequest.getPageNo();
        if (pageSize == null || pageNo == null) {
            return new Result<>("传入页数或页数大小为空", 306);
        }
        if (!checkInt.check(pageNo) || !checkInt.check(pageSize))
            return new Result<>("传入参数不是整数", 307);
        return new Result<>(commentService.findAllCommentPages(PageRequest.of(Integer.parseInt(pageNo) - 1, Integer.parseInt(pageSize))));
    }

    @PostMapping("findByPidPages")
    public Result<List<Comment>> findByPidPages(@RequestBody CommentFindRequest commentFindRequest) {
        String pageSize = commentFindRequest.getPageSize();
        String pageNo = commentFindRequest.getPageNo();
        String pid = commentFindRequest.getPid();
        if (pageSize == null || pageNo == null || pid == null)
            return new Result<>("传入页数或页数大小为空", 306);
        if (!checkInt.check(pageNo) || !checkInt.check(pageSize) || !checkInt.check(pid))
            return new Result<>("传入参数不是整数", 307);
        List<Comment> list = commentService.getCommentByPid(Integer.parseInt(pid));
        int total = list.size(), ps = Integer.parseInt(pageSize), pn = Integer.parseInt(pageNo);
        int l = ps * (pn-1)+1, r = l+ps-1;
        if(r>total) r = total;
        if(l<r) return new Result<>("已无值", 308);
        return new Result<>(list.subList(l-1,r));
    }
    @PostMapping("findByUidPages")
    public Result<List<Comment>> findByUidPages(@RequestBody CommentFindRequest commentFindRequest){
        String pageSize = commentFindRequest.getPageSize();
        String pageNo = commentFindRequest.getPageNo();
        String uid = commentFindRequest.getUid();
        if (pageSize == null || pageNo == null || uid == null)
            return new Result<>("传入页数或页数大小为空", 306);
        if (!checkInt.check(pageNo) || !checkInt.check(pageSize) || !checkInt.check(uid))
            return new Result<>("传入参数不是整数", 307);
        List<Comment>list = commentService.getCommentByUid(Integer.parseInt(uid));
        int total = list.size(), ps = Integer.parseInt(pageSize), pn = Integer.parseInt(pageNo);
        int l = ps * (pn-1)+1, r = l+ps-1;
        if(r>total) r = total;
        if(l<r) return new Result<>("已无值", 308);
        return new Result<>(list.subList(l-1,r));
    }
}
