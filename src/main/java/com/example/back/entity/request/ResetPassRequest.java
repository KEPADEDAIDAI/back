package com.example.back.entity.request;

import lombok.Data;

@Data
public class ResetPassRequest {
    private String email;
    private String upass;
    private String repass;
}
