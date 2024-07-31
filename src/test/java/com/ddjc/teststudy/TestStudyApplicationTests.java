package com.ddjc.teststudy;

import com.ddjc.teststudy.beans.menuDTO;
import com.ddjc.teststudy.config.OSSconfig;
import com.ddjc.teststudy.config.SMSconfig;
import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.mapper.TbUserMapper;
import com.ddjc.teststudy.service.implement.fileImplement;
import com.ddjc.teststudy.service.testService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

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


//    测试连接数据库
    @Autowired
    TbUserMapper tbUserMapper;
    @Test
    void test002(){
        TbUser tbUsers = tbUserMapper.selectByAccount("111");
        System.out.println(tbUsers);
    }


//递归测试
    public int add(int a, int b){

        int c=a+b;
        ;
        if(c<100)
            return c;
        else
            return c=add(a,b-100);
    }

    @Test
    void test003(){
        int c=add(1,2);
        System.out.println(c);

    }

    @Autowired
    com.ddjc.teststudy.service.rbacService rbacService;

    @Test
    void test004(){

        List<menuDTO> menuTree = rbacService.generateMenuTree(1);


              for(menuDTO menu:menuTree)
              {
                  System.out.println(menu);
                  for(menuDTO menu2:menu.getChildren())
                  {
                      System.out.println(menu2);
                  }
              }

    }
    @Autowired
    SMSconfig smsConfig;

    @Autowired
    com.ddjc.teststudy.service.SMSservice smsService;


//    测试sms
    @Test
    void test005(){
        System.out.println(smsConfig.getAccessKeyId());
        smsService.sendSMS("13677247315","135246890");
    }


    @Autowired
    OSSconfig osSconfig;

    @Autowired
    fileImplement fileImplement;
    //    测试oss
    @Test
    void test006(){
        System.out.println(osSconfig.getBucketName());

//        InputStream inputStream = new FileInputStream();
//        fileImplement.upload("test.txt","/Users/ddjc/Desktop/test.txt");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test007() {
    redisTemplate.opsForValue().set("name","zds",20, TimeUnit.SECONDS);
    System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Test
    void test008() {
       jsonRedisTemplate.opsForValue().set("name", "zds", 20, TimeUnit.SECONDS);

    }
}
