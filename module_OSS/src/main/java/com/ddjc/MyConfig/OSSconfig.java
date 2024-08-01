package com.ddjc.MyConfig;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "config.oss")
@Data
@Configuration
@Component
public class OSSconfig {
    //oss相关配置
    private String endpoint; //区域地
    private String keyID;   //对象存储Id
    private String keySecret;//对象存储密钥
    private String bucketName;//桶名称

    @Bean
    public OSS getOSSconfig() {
        OSS ossClient = new OSSClientBuilder().build(this.endpoint, this.keyID, this.keySecret);

        if (!ossClient.doesBucketExist(this.bucketName)) {
            ossClient.createBucket(this.bucketName); //创建桶

            ossClient.setBucketAcl(this.bucketName, CannedAccessControlList.PublicRead); //设置桶权限为公共读

        }

        return ossClient;
    }
}
