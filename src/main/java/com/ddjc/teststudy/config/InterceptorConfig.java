package com.ddjc.teststudy.config;


import com.ddjc.teststudy.interceptor.myInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new myInterceptor())
               .addPathPatterns("/**")
               .excludePathPatterns("");
    }
}
