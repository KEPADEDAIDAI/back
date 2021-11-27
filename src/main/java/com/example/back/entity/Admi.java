package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Admi {
    @Id
    private Integer cid;
    private String cname;
    private String c_pas;
}
