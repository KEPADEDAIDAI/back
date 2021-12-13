package com.example.back.controller;

import com.example.back.entity.Pic;
import com.example.back.entity.Result;
import com.example.back.request.UserAddRequest;
import com.example.back.request.UserUid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class UploadHandler {
    @Value("${image.tx}")
    private String filePath;
    @PostMapping("/upload")
    public Result<List<Pic>> upload(MultipartFile file, String uid) {
        if (file.isEmpty()) {

            return new Result<>("文件为空", 501);
        }
        File dest = new File(filePath + uid+".jpg");
        try {
            System.out.println("ok");
            file.transferTo(dest);
            // LOGGER.info("上传成功");
            return new Result<>("success", 1);
        } catch (IOException e) {
            // LOGGER.error(e.toString(), e);
        }
        return new Result<>("fail", 0);
    }

}
