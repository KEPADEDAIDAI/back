package com.example.back.request;

import lombok.Data;

@Data
public class CommentFindRequest {
    private String uid;
    private String pid;
    private String pageSize;
    private String pageNo;
}
