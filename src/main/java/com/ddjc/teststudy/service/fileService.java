package com.ddjc.teststudy.service;

import java.io.InputStream;

public interface fileService {
    /***
     * 上传文件
     * @param inputstream 要上传文件的文件流
     * @param module 上传到目标服务器的文件夹
     * @param originFieldName 上传文件的字段名
     * @return 文件存储路径 oss服务器上
     */

    public String upload(InputStream inputstream, String module, String originFieldName);


    /***
     * 头像关联
     * @param userId 用户id
     * @param avatarUrl 头像路径
     */
    public String avatarAssociate(String userId, String avatarUrl);
}
