package com.example.back.repository;

import com.example.back.entity.Pic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PicRepositoryTest {

    @Autowired
    private PicRepository picRepository;
    @Test
    void findAll(){
        System.out.println(picRepository.findAll());
    }

    @Test
    void getPicsByTime()
    {
        System.out.println(picRepository.getPicsByTime("2021-11-19", "2021-11-19"));
    }
//    @Test
//    void SavePic()
//    {
//        Pic pic = new Pic();
//        pic.setPurl("/pic4");
//        pic.setPtxt("图4");
//        pic.setPplacesheng("浙江");
//        pic.setPplaceshi("杭州");
//        pic.setPplaceqv("西湖");
//        pic.setPtimestart("2021-12-6");
//        pic.setPtimeend("2021-12-10");
//        pic.setPname("pic4");
//        System.out.println(pic);
//        System.out.println(2);
//        System.out.println(picRepository.save(pic));
//    }
//    @Test
//    void DelPic()
//    {
//        picRepository.deleteByPid(5);
//    }
}