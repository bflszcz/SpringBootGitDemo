package com.bflsz.springbootgit.config;

import com.bflsz.springbootgit.interceptor.CrossInterceptorHandler;
import com.bflsz.springbootgit.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossInterceptorHandler()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/users/login","/error/**");
    }
}
