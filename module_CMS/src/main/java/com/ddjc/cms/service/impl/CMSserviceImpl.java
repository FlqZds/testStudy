package com.ddjc.cms.service.impl;

import com.ddjc.cms.entity.Content;
import com.ddjc.cms.service.CMSservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CMSserviceImpl implements CMSservice {


    @Override
    public Boolean addContent(String title, String content) {
        return null;
    }

    @Override
    public List<Content> showContent(Integer contentId) {

        log.info("showContent");



        return null;
    }
}
