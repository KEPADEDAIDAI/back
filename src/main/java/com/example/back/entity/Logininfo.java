package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Logininfo {
    @Id
    private Integer loadid;
    private Integer uid;
    private String loadtime;
    private String loadip;

}
