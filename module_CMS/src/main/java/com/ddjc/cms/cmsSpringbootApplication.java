package com.ddjc.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.ddjc.cms.mapper")
@EnableCaching
public class cmsSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(cmsSpringbootApplication.class, args);
    }
}
