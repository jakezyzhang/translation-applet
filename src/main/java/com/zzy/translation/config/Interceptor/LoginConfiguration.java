package com.zzy.translation.config.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginConfiguration implements WebMvcConfigurer, HandlerInterceptor {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        //拦截路径
//        loginRegistry.addPathPatterns("/Article/queryArticle");
        loginRegistry.addPathPatterns("/Pages/queryTable");
        loginRegistry.addPathPatterns("/Pages/queryTableEditor");
        loginRegistry.addPathPatterns("/Pages/increaseOrEditor");
        loginRegistry.addPathPatterns("/Pages/index");
        loginRegistry.addPathPatterns("/Pages/fileTree");
        //排除路径
//        loginRegistry.excludePathPatterns("/**");
//        loginRegistry.excludePathPatterns("/User/loginUser");
//        loginRegistry.excludePathPatterns("/pages/register.html");
////        //排除资源请求
//        loginRegistry.excludePathPatterns("/css/*.css");
//        loginRegistry.excludePathPatterns("/fonts/**");
//        loginRegistry.excludePathPatterns("/images/**");
//        loginRegistry.excludePathPatterns("/jQuery/*.js");
//        loginRegistry.excludePathPatterns("/js/*.js");
//        loginRegistry.excludePathPatterns("/layui/**");

    }
}
