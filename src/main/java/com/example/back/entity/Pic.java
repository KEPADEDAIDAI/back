package com.example.back.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity

@Data
public class Pic {
    @Id
    private Integer pid;
    private String purl;
    private String pname;
    private Date ptimestart;
    private Date ptimeend;
    private String pplacesheng;
    private String pplaceshi;
    private String pplaceqv;
    private String pplaceold;
    private String ptxt;

}
