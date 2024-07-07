package com.ddjc.teststudy;

import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.mapper.TbUserMapper;
import com.ddjc.teststudy.service.testService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TestStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    testService testService;

//    @Autowired
//    teacher teacher;
//
//    @Test
//    void test001(){
//        String s = testService.test001();
//        System.out.println(s);
//        teacher.teach();
//    }


    @Autowired
    TbUserMapper tbUserMapper;
    @Test
    void test002(){
        List<TbUser> tbUsers = tbUserMapper.selectByUsername("丁元英");
        System.out.println(Arrays.toString(tbUsers.toArray()));
    }


}
