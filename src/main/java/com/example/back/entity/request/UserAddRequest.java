package com.example.back.entity.request;

import lombok.Data;

@Data
public class UserAddRequest {
    private String email;
    private String uname;
    private String upass;
    private String tempcode;
    private String phone;
}
