package com.example.back.controller;

import com.example.back.entity.Pic;
import com.example.back.entity.Result;
import com.example.back.repository.PicRepository;
import com.example.back.server.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pic")
public class PicHandler {
    @Autowired
    private PicRepository picRepository;

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
        System.out.println(t1);
        return new Result<>(picService.findByTime(t1,t2));
    }

//    @RequestMapping("/setPic")
//    private Result<List<Pic>> setPic(@RequestBody Pic entity)
//    {
//        String json =
//    }

}
