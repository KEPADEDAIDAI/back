package com.example.back.request;

import lombok.Data;

@Data
public class AddCommentRequest {
    private String pid;
    private String uid;
    private String pltxt;
}
