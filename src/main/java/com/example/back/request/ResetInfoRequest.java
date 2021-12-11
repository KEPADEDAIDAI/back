package com.example.back.request;

import lombok.Data;

@Data
public class ResetInfoRequest {
    private String email;
    private String uname;
    private String phone;
    private String sex;
    private String birthday;
    private String qq;
    private String wechat;
}
