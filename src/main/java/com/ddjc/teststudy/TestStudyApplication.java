package com.ddjc.teststudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@Import(teacher.class)
@MapperScan("com.ddjc.teststudy.mapper")
@EnableCaching // 开启缓存
public class TestStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestStudyApplication.class, args);
    }

}
