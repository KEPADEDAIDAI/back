package com.example.back.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plid;
    private String pltime;
    private Integer uid;
    private Integer pid;
    private String pltxt;
    @Transient
    private String uname;
}
