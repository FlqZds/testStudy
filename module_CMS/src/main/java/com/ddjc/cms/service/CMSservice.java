package com.ddjc.cms.service;

import com.ddjc.cms.entity.Content;

import java.util.List;

public interface CMSservice {
//    新增内容
    public Integer addContent(Content content);

//    展示内容
    public List<Content> showContent(Integer contentId);

}
