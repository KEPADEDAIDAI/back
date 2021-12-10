package com.example.back.controller;

import com.example.back.entity.Pic;
import com.example.back.entity.Result;
import com.example.back.entity.request.SetPicRequest;
import com.example.back.repository.PicRepository;
import com.example.back.server.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/pic")
public class PicHandler {



    @Autowired
    private PicService picService;

    @GetMapping("/findAll")
    public Result<List<Pic>> findAll() {
        return new Result<>(picService.findAll());
    }

    @GetMapping("/findById/{id}")
    public Result<List<Pic>> findById(@PathVariable("id") Integer id) {
//        System.out.println("id="+id);
        return new Result<>(picService.findById(id));
    }

    @GetMapping("/findByPlacesheng/{sheng}")
    public Result<List<Pic>> findByPlacesheng(@PathVariable("sheng") String sheng) {
//        System.out.println(sheng);
        return new Result<>(picService.findByPlacesheng(sheng));
    }

    @GetMapping("/findByPlaceshi/{shi}")
    private Result<List<Pic>> findByPlaceshi(@PathVariable("shi") String shi) {
        return new Result<>(picService.findByPlaceshi(shi));
    }

    @GetMapping("/findByPlaceqv/{qv}")
    private Result<List<Pic>> findByPlacesqv(@PathVariable("qv") String qv) {
        return new Result<>(picService.findByPlaceqv(qv));
    }

    @GetMapping("/findByPlaceold/{name}")
    private Result<List<Pic>> findByPlaceold(@PathVariable("name") String name) {
        return new Result<>(picService.findByPlaceold(name));
    }

    @GetMapping("/findByTime/{t1}/{t2}")
    private Result<List<Pic>> findByTime(@PathVariable("t1") String t1, @PathVariable("t2") String t2) {
//        System.out.println(t1);
        return new Result<>(picService.findByTime(t1,t2));
    }

//    @PostMapping ("/setPic")
//    private Result<List<Pic>> setPic(@RequestBody SetPicRequest setPicRequest)
//    {
//        Pic pic = new Pic();
//        pic.setPname(setPicRequest.getPname());
//        pic.setPplacesheng(setPicRequest.getPplacesheng());
//        pic.setPplaceshi(setPicRequest.getPplaceshi());
//        pic.setPplaceqv(setPicRequest.getPplaceqv());
//        pic.setPplaceold(setPicRequest.getPplaceold());
//        pic.setPtxt(setPicRequest.getPtxt());
//        pic.setPtimestart(setPicRequest.getPtimestart());
//        pic.setPtimeend(setPicRequest.getPtimeend());
//        return new Result<>(picService.SavePic(pic));
//    }
    @GetMapping("/del/{id}")
    private Result<List<Pic>> Del(@PathVariable("id") Integer id)
    {

        if(!picService.existsByPid(id))
        {
            return new Result<>("该id图片不存在", 102);
        }
        picService.DelByPid(id);
        return new Result<>("success",1);
    }
}
