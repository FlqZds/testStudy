package com.ddjc.teststudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.BitSet;

@SpringBootTest
class TestStudyApplicationTests_2 {

    @Test
    void contextLoads() {
        BitSet bitSet = new BitSet(10);
        bitSet.set(0, true);
        bitSet.set(1, true);
        bitSet.set(8);


        System.out.println(bitSet.length());
        System.out.println(bitSet.get(8));
    }

    //    测试redis
//    @Autowired
//    private RedisTemplate redisTemplate;

}
