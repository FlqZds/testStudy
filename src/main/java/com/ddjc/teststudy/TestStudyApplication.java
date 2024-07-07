package com.ddjc.teststudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(teacher.class)
@MapperScan("com.ddjc.teststudy.mapper")
public class TestStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestStudyApplication.class, args);
    }

}
