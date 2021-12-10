package com.example.back.server;

import com.example.back.entity.Pic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PicServiceTest {

    @Autowired
    private PicService picService;

//    @Test
//    private void findAllByPages()
//    {
//        PageRequest pageRequest = PageRequest.of(2,10);
//        List<Pic> list = picService.findAllByPages(pageRequest);
//        System.out.println(list);
//    }
}