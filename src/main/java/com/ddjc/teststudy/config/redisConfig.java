package com.ddjc.teststudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@SpringBootConfiguration
public class redisConfig extends RedisAutoConfiguration {

// 设置redisTmplate的序列化方案
//    json
    @Bean("jsonRedisTemplate")
    public RedisTemplate<String, Serializable> JsonRedisTemplate(@Autowired LettuceConnectionFactory ltfc){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(ltfc);  // 设置连接工厂

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }


    //    jdk
    @Bean("jdkRedisTemplate")
    public RedisTemplate<String, Serializable> jdkRedisTemplate( @Autowired LettuceConnectionFactory ltfc){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(ltfc);

        return redisTemplate;
    }


    //    string
    @Bean("strRedisTemplate")
    public RedisTemplate<String, Serializable> StringRedisTemplate(@Autowired LettuceConnectionFactory ltfc){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(ltfc);
        return redisTemplate;
    }
}
