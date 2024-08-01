package com.ddjc.service.implement;

import com.aliyun.oss.OSS;
import com.ddjc.MyConfig.OSSconfig;
import com.ddjc.service.fileService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Service
public class fileImplement implements fileService {

    @Autowired(required = true)
    private OSSconfig osSconfig;

    @Autowired
    private OSS ossClient;

    /***
     * 上传文件到目标服务器
     * @param inputstream 要上传文件的文件流
     * @param module 上传到目标服务器的哪个文件夹
     * @param originFileName 上传文件的原始名
     * @return 上传成功返回上传路径, 失败返回错误信息
     */
    @Override
    public String upload(InputStream inputstream, String originFileName, String module) {
        //初始化OSS客户端

//构建上传文件的文件路径
        String upload_date = new DateTime().toString("yyyy/MM/dd");

        String upload_fileName = UUID.randomUUID().toString();  //生成随机文件名 ,用以覆盖原始文件名
        String upload_suffix = originFileName.substring(originFileName.lastIndexOf("."));//获取文件后缀名

        String upload_filePath = module + File.separator + upload_date + File.separator + upload_fileName + upload_suffix; //拼接上传文件路径

        // 上传文件到阿里云OSS
        ossClient.putObject(osSconfig.getBucketName(), upload_filePath, inputstream);

        //关闭文件流和OSS客户端
        ossClient.shutdown();

        //返回上传成功后的路径
        String url = "https://" + osSconfig.getBucketName() + "." + osSconfig.getEndpoint() + "/" + upload_filePath;
        return url;

    }

    @Override
    public String avatarAssociate(String userId, String avatarUrl) {

        return null;
    }


//    public String uploadLocal()


}
