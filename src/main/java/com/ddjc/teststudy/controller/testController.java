package com.ddjc.teststudy.controller;

import com.ddjc.teststudy.beans.userDTO;
import com.ddjc.teststudy.common.JWTutil;
import com.ddjc.teststudy.common.R;
import com.ddjc.teststudy.common.ResponseEnum;
import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.service.testService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Data
public class testController {
    @Autowired
    private testService testService;

    @GetMapping("test001")
    public R basic_test001(){
        String s = testService.test001();
//        int i = 1/0;
        System.out.println("已经执行test001函数");

        return new R(ResponseEnum.SUCCESS, s);
    }

    @Autowired
    private JWTutil jwtutil;

    @GetMapping("login")
    public R login_test001(String userName, String userPassword){
        TbUser user = testService.login(userName, userPassword);
//        int i = 1/0;
        System.out.println("已经执行login函数");

        userDTO userDTO = new userDTO();
        BeanUtils.copyProperties(user, userDTO);

        String jwt = jwtutil.generateJwt(userDTO);
        userDTO.setToken(jwt);

        return new R(ResponseEnum.SUCCESS, userDTO);
    }



}



