package com.ddjc.cms.mapper;

import com.ddjc.cms.entity.ContentType;
import com.ddjc.cms.entity.ContentTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentTypeMapper {
    int countByExample(ContentTypeExample example);

    int deleteByExample(ContentTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContentType record);

    int insertSelective(ContentType record);

    List<ContentType> selectByExample(ContentTypeExample example);

    ContentType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByExample(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByPrimaryKeySelective(ContentType record);

    int updateByPrimaryKey(ContentType record);
}