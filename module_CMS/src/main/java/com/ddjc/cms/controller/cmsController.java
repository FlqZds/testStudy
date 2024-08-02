package com.ddjc.cms.controller;

import com.ddjc.cms.entity.Content;
import com.ddjc.cms.service.CMSservice;
import com.ddjc.common.RESTFUL.Result;
import com.ddjc.common.RESTFUL.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class cmsController {
    @Autowired
    private CMSservice cmsService;

    @GetMapping("/{typeID}")  //改为路径参数
    public Result index(@PathVariable("typeID") Integer typeID) {

        List<Content> contents = cmsService.showContent(typeID);
//        Optional<List<Content>> contents = cmsService.showContent(typeID);

        return new Result(ResponseEnum.SUCCESS, contents);
    }


}
