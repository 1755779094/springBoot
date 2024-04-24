package com.mjq.bigevent.config;

import com.mjq.bigevent.inteceptor.TokenInceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Autowired
    private TokenInceptor tokenInceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录和注册接口不拦截
        registry.addInterceptor(tokenInceptor).excludePathPatterns("/user/register","/user/login");
    }
}
