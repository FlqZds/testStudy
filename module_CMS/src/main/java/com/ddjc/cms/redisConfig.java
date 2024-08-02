package com.ddjc.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

@SpringBootConfiguration
public class redisConfig extends RedisAutoConfiguration {

    //    配置缓存工厂/缓存管理器
    @Bean
    public CacheManager cacheManager(@Autowired LettuceConnectionFactory ltfc) {

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600))// 设置缓存有效期为10分钟
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())) // 设置value序列化方案为json
                .disableCachingNullValues();

//cacheManager只是接口，具体实现由RedisCacheManager实现
        return RedisCacheManager.builder(ltfc).cacheDefaults(config).build();
    }


    // 设置redisTmplate的序列化方案
//    json
    @Bean("jsonRedisTemplate")
    public RedisTemplate<String, Serializable> JsonRedisTemplate(@Autowired LettuceConnectionFactory ltfc) {
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
    public RedisTemplate<String, Serializable> jdkRedisTemplate(@Autowired LettuceConnectionFactory ltfc) {
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
    public RedisTemplate<String, Serializable> StringRedisTemplate(@Autowired LettuceConnectionFactory ltfc) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(ltfc);
        return redisTemplate;
    }
}
