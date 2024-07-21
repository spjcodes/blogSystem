package com.jiayeli.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
//                .allowedOrigins("*") https://blog.csdn.net/peng2hui1314/article/details/131035556
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
