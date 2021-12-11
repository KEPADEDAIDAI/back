package com.example.back.request;

import lombok.Data;

@Data
public class ResetPassRequest {
    private String email;
    private String upass;
    private String repass;
}
