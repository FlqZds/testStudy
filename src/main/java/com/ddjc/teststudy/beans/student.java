package com.ddjc.teststudy.beans;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PropertySource(name = "stu.properties",value = "classpath*:stu.properties")
@ConfigurationProperties(prefix = "student")
public class student {
//    @Value("${student.name}")
    private String name;
//    @Value("${student.age}")
    private Integer age;
//    @Value("${student.sex}")
    private Integer sex;
//    @Value("${student.address.[0]}")

    @Singular("address")
    private List address;
}
