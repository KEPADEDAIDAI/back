package com.example.back.entity.request;

import lombok.Data;

/**
 * @author 16697
 */
@Data
public class LoginRequest {

    private String email;

    private String upass;
}
