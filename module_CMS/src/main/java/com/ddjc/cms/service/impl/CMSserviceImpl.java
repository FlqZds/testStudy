package com.ddjc.cms.service.impl;

import com.ddjc.cms.entity.Content;
import com.ddjc.cms.mapper.ContentMapper;
import com.ddjc.cms.service.CMSservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CMSserviceImpl implements CMSservice {


    @Autowired
    private ContentMapper contentMapper;

    @Override
    @CacheEvict(value = "a",key = "#content.type")  // 清除缓存中对应了typeID所有数据的缓存
    public Integer addContent(Content content) {
        log.info("加一个内容");

        int insertResult  = contentMapper.insert(content);


        return insertResult;
    }


    // 通过种类id，显示内容
    @Override
    @Cacheable(value = "a", key = "#contentId")
    public List<Content> showContent(Integer contentId) {

        log.info("showContent");


//        PageHelper.startPage(0, 3);

       List<Content> contents = contentMapper.showAllContentByTypeId(contentId);

        return contents;
    }
}
