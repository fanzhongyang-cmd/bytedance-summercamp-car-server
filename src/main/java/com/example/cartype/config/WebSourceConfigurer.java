package com.example.cartype.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSourceConfigurer implements WebMvcConfigurer {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//增加图片访问,相当于把后者path上的资源映射到前者的url里
        registry.addResourceHandler("/img/**").addResourceLocations("file:E:/carData/");

    }
}
