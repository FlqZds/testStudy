package com.ddjc.cms.controller;

import com.ddjc.common.RESTFUL.R;
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
    public R index() {
        return new R(ResponseEnum.SUCCESS, "cms模块首页");
    }


}
