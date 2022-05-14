package com.hebeu.miniprogram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private WebSessionInterceptor webSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webSessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login2")
                .excludePathPatterns("/user/logout");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
