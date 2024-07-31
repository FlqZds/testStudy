package com.ddjc.cms.mapper;

import com.ddjc.cms.entity.Content;
import com.ddjc.cms.entity.ContentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContentMapper {
    int countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Integer contentId);

    int insert(Content record);

    int insertSelective(Content record);


    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Integer contentId);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

//    根据内容id查出对应content的所有数据
    List<Content> selectByContentId(Integer contentId);
}