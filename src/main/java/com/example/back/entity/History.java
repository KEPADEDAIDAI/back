package com.example.back.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid; //浏览id
    private Integer uid;
    private String ltime;//浏览时间
    private Integer pid;//浏览的画

}
