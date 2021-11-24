package com.example.back.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data

public class Test {

    @Id
    private Integer id;
    private String text;
}
