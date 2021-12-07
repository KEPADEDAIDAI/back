package com.example.back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@RestController
public class UploadHandler {
    @Value("${image.location}")
    private String filePath;
    @PostMapping("/up")
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();

        File dest = new File(filePath + fileName);
        try {
            System.out.println("ok");
            file.transferTo(dest);
            // LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            // LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

}
