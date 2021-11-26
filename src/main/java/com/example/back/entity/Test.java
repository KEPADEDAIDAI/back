package com.example.back.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity

@Data
public class Test {

    @Id
    private Integer id;
    private String text;

}
