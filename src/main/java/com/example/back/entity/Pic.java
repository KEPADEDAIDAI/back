package com.example.back.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity

@Data
public class Pic {
    @Id
    private Integer pid;
    private String purl;
    private String pname;
    private String ptime_start;
    private String ptime_end;
    private String pplace_sheng;
    private String pplace_shi;
    private String pplace_qv;
    private String pplace_old;
    private String ptxt;

}
