package com.example.back.repository;

import com.example.back.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PicRepository extends JpaRepository<Pic, Integer> {
    List<Pic> getPicByPid(Integer id);

    List<Pic> getPicsByPplacesheng(String sheng);

    List<Pic> getPicsByPplaceshi(String shi);

    List<Pic> getPicsByPplaceqv(String qv);

    List<Pic> getPicsByPplaceold(String name);

    @Query(value = "SELECT * FROM pic WHERE ( :ts >= pic.ptimestart AND :ts <= pic.ptimeend) OR (:te <= pic.ptimeend AND pic.ptimestart <= :te)", nativeQuery = true)
    List<Pic> getPicsByTime(@Param("ts") String ts, @Param("te") String te);

    List<Pic> getPicsByPname(String name);

    boolean existsByPname(String name);

    boolean existsByPid(Integer id);

    @Transactional
    void deleteByPid(Integer id);
}
