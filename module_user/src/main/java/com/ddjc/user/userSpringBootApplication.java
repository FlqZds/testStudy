package com.ddjc.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddjc.user.mapper")
public class userSpringBootApplication {
    public static void main(String[] args) {
        // 启动程序

        SpringApplication.run(userSpringBootApplication.class, args);
    }
}
