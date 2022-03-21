package com.example.back.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Md5 {
    public static String md5(String password, String email)
    {
        try{
            String string = password.toString() +email.toString();
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] bytes = md.digest(string.getBytes());
            return Base64.getEncoder().encodeToString(bytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
