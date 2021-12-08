package com.example.back.entity.request;

import lombok.Data;

@Data
public class AddCommentRequest {
    private String pid;
    private String uid;
    private String pltxt;
}
