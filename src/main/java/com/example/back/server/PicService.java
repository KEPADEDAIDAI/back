package com.example.back.server;

import com.example.back.entity.Pic;
import com.example.back.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {
    @Autowired
    PicRepository picRepository;

    public List<Pic> findById(Integer id) {//按照id查找
        return picRepository.getPicByPid(id);
    }

    public List<Pic> findAll() {
        return picRepository.findAll();
    }

    public List<Pic> findByPlacesheng(String sheng) {
        return picRepository.getPicsByPplacesheng(sheng);
    }

    public List<Pic> findByPlaceshi(String shi) {
        return picRepository.getPicsByPplaceshi(shi);
    }

    public List<Pic> findByPlaceqv(String qv){
        return picRepository.getPicsByPplaceqv(qv);
    }

    public List<Pic> findByPlaceold(String name){
        return picRepository.getPicsByPplaceold(name);
    }

    public List<Pic> findByTime(String t1, String t2){
//        System.out.println(t1);
//        System.out.println(t2);
        return picRepository.getPicsByTime(t1,t2);
    }

    public List<Pic> SavePic(Pic pic){
        picRepository.save(pic);
        return picRepository.getPicsByPname(pic.getPname());
    }
}
