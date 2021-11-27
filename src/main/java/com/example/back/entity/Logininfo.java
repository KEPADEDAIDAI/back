package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Logininfo {
    @Id
    private Integer load_id;
    private Integer uid;
    private String load_time;
    private String load_ip;

}
