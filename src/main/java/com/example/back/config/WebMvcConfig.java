package com.example.back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SuppressWarnings("All")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Value("${image.location}")
    private String filePath;
    @Value("${image.tx}")
    private String filePath2;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //  /home/file/**为前端URL访问路径  后面 file:xxxx为本地磁盘映射
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+filePath);
        registry.addResourceHandler("/images2/**").addResourceLocations("file:"+filePath2);
    }
}
