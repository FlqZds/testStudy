package com.ddjc.teststudy.service;


import com.ddjc.teststudy.beans.student;
import com.ddjc.teststudy.common.ResponseEnum;
import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.exception.AppException;
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


    public TbUser login(String userAccount, String userPassword) {

        if (Strings.isEmpty(userAccount) || Strings.isEmpty(userPassword)) {
            throw new AppException(ResponseEnum.USERNAME_OR_PASSWORD_INVALIDATE);
        }

        TbUser tbUser = tbUserMapper.selectByAccount(userAccount);

//        user user = com.ddjc.teststudy.beans.user.builder()
//
//                .userName(userName)
//                .userPassword(userPassword)
//                .userAddress(Arrays.asList("北京", "上海", "广州", "深圳"))
//                .build();
////        int i = 1 / 0;





        return tbUser;
    }
}
