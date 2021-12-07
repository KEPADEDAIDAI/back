package com.example.back.entity.request;

import lombok.Data;

@Data
public class ResetInfoRequest {
    private String email;
    private String uname;
    private String phone;
}
