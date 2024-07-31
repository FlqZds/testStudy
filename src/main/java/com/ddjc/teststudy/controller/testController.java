package com.ddjc.teststudy.controller;

import com.ddjc.common.RESTFUL.Result;
import com.ddjc.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.beans.menuDTO;
import com.ddjc.teststudy.beans.userDTO;
import com.ddjc.teststudy.common.JWTutil;
import com.ddjc.teststudy.common.ano.checkLogin;
import com.ddjc.teststudy.common.ano.emPowerment;
import com.ddjc.teststudy.entity.TbUser;
import com.ddjc.teststudy.service.testService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Data
@Slf4j
@RequestMapping("/test")
@Tag(name = "测试模块")
public class testController {
    @Autowired
    private testService testService;


    @GetMapping("test001")
    public Result basic_test001() {
        String s = testService.test001();
//        int i = 1/0;
        log.info("已经执行test001函数");

        return new Result(ResponseEnum.SUCCESS, s);
    }

    @Autowired
    private JWTutil jwtutil;



    @Operation(summary = "测试接口")
    // 登录接口
    @GetMapping("login")
    public Result login_test001(String userName, String userPassword) {
        TbUser user = testService.login(userName, userPassword);
//        int i = 1/0;
        log.info("已经执行login函数");


        log.info("打印user对象：" + user);

        userDTO userDTO = new userDTO();
        BeanUtils.copyProperties(user, userDTO);

        String jwt = jwtutil.generateJwt(userDTO);
        userDTO.setToken(jwt);

//        String json_u = JSON.toJSONString(userDTO);  // 将对象转换为json字符串,然后返回给前端，然后前端误将这个json字符串判断为json对象，导致前端无法 将这个json字符串转为json对象，也无法转为json字符串，虽然可以正常显示，但是无法操作任何数据。

        log.info("打印userDTO对象：" + userDTO);

        Result result = new Result(ResponseEnum.SUCCESS, userDTO);
        return result;
    }


//    @GetMapping("infoCheck")
//    public R infoCheck_test001(@RequestHeader(required = false, value = "X-Token") String token) {
//        System.out.println("已经执行infoCheck函数" + token);
//
//        userDTO front = jwtutil.checkJwt(token);
//
//        System.out.println("打印前端传来的userDTO对象：" + front);
//
//
//        R r = new R(ResponseEnum.SUCCESS, null);
//        return r;
//    }

    @Autowired
    private com.ddjc.teststudy.service.rbacService rbacService;


    //菜单权限 - 树状菜单
    @GetMapping("menu")
    @checkLogin
    public Result menu_test001(HttpServletRequest request) {
//todo 前端传来的token需要验证，防止伪造token
//todo token参数校验

        Integer roleId = (Integer) request.getAttribute("roleId");

        List<menuDTO> menuTree = rbacService.generateMenuTree(roleId);
//todo menuTree 参数校验
        log.info("已经执行menu函数");
        return new Result(ResponseEnum.SUCCESS, menuTree);
    }



    @emPowerment(value = "TEST_AUDIT")
    @GetMapping("/aduit")
    public Result approval_test001() {
        log.info("审批测试001");
        return new Result(ResponseEnum.SUCCESS, null);
    }

    @emPowerment(value = "TEST_SEARCH")
    @GetMapping("/search")
    public Result search_test001() {
        log.info("搜索测试001");
        return new Result(ResponseEnum.SUCCESS, null);
    }


    @Autowired
    private com.ddjc.teststudy.service.SMSservice smsService;


    @checkLogin
    @GetMapping("/smsTest")
    public Result smsTest_test001(@RequestParam String phone, @RequestParam String code) {
        smsService.sendSMS(phone, code);
        return new Result(ResponseEnum.SUCCESS, null);
    }


    @Autowired
    private com.ddjc.teststudy.service.implement.fileImplement fileImplement;



    // 文件上传 oss服务器
    @checkLogin
    @PostMapping("/upload")
    public Result upload_test001(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();

        String module = "avatar";

        String url = fileImplement.upload(inputStream, originalFilename, module);
        return new Result(ResponseEnum.SUCCESS, url);
    }

    @GetMapping("/tt")
    public String tt_test001() {
        return"qweqeqweqwe";
    }
}



