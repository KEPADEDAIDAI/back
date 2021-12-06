package com.example.back.controller;

import com.example.back.entity.History;
import com.example.back.entity.Result;
import com.example.back.repository.HistoryReposotory;
import com.example.back.server.HistoryService;
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
@RequestMapping("/history")
public class HistoryHandler {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PicService picService;
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public Result<List<History>> findAll() {
        return new Result<>(historyService.findAll());
    }

    @GetMapping("/findByLid/{id}")
    public Result<List<History>> findByLid(@PathVariable("id") Integer id) {
        return new Result<>(historyService.findByLid(id));
    }

    @GetMapping("/findByPid/{id}")
    public Result<List<History>> findByPid(@PathVariable("id") Integer id){
        return new Result<>((historyService.findByPid(id)));
    }
    @GetMapping("/findByUid/{id}")
    public Result<List<History>> findByUid(@PathVariable("id") Integer id){
        return new Result<>(historyService.findByUid(id));
    }

    @PostMapping("/add")
    public Result<List<History>> add(HttpServletRequest request)
    {
        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");
        if(!checkInt.check(uid))
            return new Result<>("用户id不是整数", 401);
        if(!checkInt.check(pid))
            return new Result<>("图片id不是整数",402);
        History history = new History();
        history.setPid(Integer.valueOf(pid));
        history.setUid(Integer.valueOf(uid));
        if(!picService.existsByPid(history.getPid()))
            return new Result<>("指定图片不存在",403);
        if(!userService.existsByUid(history.getUid()))
            return new Result<>("指定用户不存在", 404);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        history.setLtime(sdf.format(new Date()));
        return new Result<>(historyService.SaveHistory(history));
    }
}
