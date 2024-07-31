package com.ddjc.teststudy.service;

import com.ddjc.common.Exception.AppException;
import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.beans.student;
import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.mapper.TbUserMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {
    @Autowired
    private student student;


    public String test001() {

        return "Hello 我是Test 001 :下面是我的个人介绍<br>" + student;
    }

    /***
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */

    @Autowired
    private TbUserMapper tbUserMapper;

//登录
    public TbUser login(String userAccount, String userPassword) {

        if (Strings.isEmpty(userAccount) || Strings.isEmpty(userPassword)) {
            throw new AppException(ResponseEnum.ACCOUNT_INVALIDATE);
        }

//        查的是用户账号
        TbUser tbUser = tbUserMapper.selectByAccount(userAccount);

//        user user = com.ddjc.teststudy.beans.user.builder()
//
//                .userName(userName)
//                .userPassword(userPassword)
//                .userAddress(Arrays.asList("北京", "上海", "广州", "深圳"))
//                .build();
////        int i = 1 / 0;

        if (tbUser == null) {
            throw new AppException(ResponseEnum.USAGE_NOT_FOUND);
        }
        ;

        if (!userPassword.equals(tbUser.getUserpassword())) {
            throw new AppException(ResponseEnum.PASSWORD_ERROR);
        }

        return tbUser;
    }
}
