package com.example.back.controller;

import com.example.back.entity.Tes;
import com.example.back.server.TesService;
import com.example.back.server.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tes")
public class TesHandler {
    @Autowired
    private TesService tesService;

    @GetMapping("/test/{page}/{size}")
    private String test(@PathVariable("page") Integer page, @PathVariable("size") Integer size)
    {
        PageRequest pageRequest = PageRequest.of(page,size);
        List<Tes> list = tesService.findByTxtPages(pageRequest, "11");
        return list.toString();
    }
}
