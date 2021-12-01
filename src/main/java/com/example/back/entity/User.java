package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private Integer uid;
    private String uname;
    private String upass;
    private String repass;
    private String repasstime;
    private String email;
    private String phone;
}
