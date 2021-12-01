package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Comment {
    @Id
    private Integer plid;
    private String pltime;
    private Integer uid;
    private Integer pid;
    private String pltxt;
}
