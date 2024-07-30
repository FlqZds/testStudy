package com.ddjc.teststudy.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "config.sms")
@Data
public class SMSconfig {
//sms相关配置
    private String accessKeyId;//    访问id
    private String accessSecret;//    访问密钥
    private String regionId;//区域id
    private String signName;//签名

    @Bean
    public IAcsClient getSMSconfig() {
        DefaultProfile profile = DefaultProfile.getProfile(this.regionId, this.accessKeyId, this.accessSecret);
        IAcsClient iAcsClient = new DefaultAcsClient(profile);
        return iAcsClient;
    }


}
