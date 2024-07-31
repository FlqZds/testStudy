package com.ddjc.cms.controller;

import com.ddjc.common.RESTFUL.Result;
import com.ddjc.common.RESTFUL.ResponseEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class cmsController {
    @GetMapping("/index")
    public Result index() {
        return new Result(ResponseEnum.SUCCESS, "cms模块首页");
    }


}
