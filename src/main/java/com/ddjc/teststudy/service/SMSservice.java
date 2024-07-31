package com.ddjc.teststudy.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.ddjc.common.Exception.AppException;
import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.config.SMSconfig;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SMSservice {
    @Autowired
    SMSconfig smsconfig;

    @Autowired
    private IAcsClient acsClient;


    /***
     *    发送短信
     *    @param phone 手机号
     *    @param message 短信内容 也是验证码
      */
    public void sendSMS(String phone, String message) {
        System.out.println("手机号：" + phone + " 短信内容：" + message);

        //做一个 发给阿里云服务端的请求对象
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", smsconfig.getRegionId());
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", smsconfig.getSignName());
        request.putQueryParameter("TemplateCode", "SMS_150181589");

        Map<String,String> map = new HashMap<>();
        map.put("code",message);

        Gson gson = new Gson();
        request.putQueryParameter("TemplateParam",gson.toJson(map) );

//        发送短信给阿里云
        try {
            CommonResponse commonResponse = acsClient.getCommonResponse(request);
        } catch (ClientException e) {
            throw new AppException(ResponseEnum.SMS_SEND_ERROR);
        }

    }
}
