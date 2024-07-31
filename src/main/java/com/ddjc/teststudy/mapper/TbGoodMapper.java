package com.ddjc.teststudy.mapper;

import com.ddjc.teststudy.entity.TbGood;
import com.ddjc.teststudy.entity.TbGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodMapper {
    int countByExample(TbGoodExample example);

    int deleteByExample(TbGoodExample example);

    int deleteByPrimaryKey(Integer goodId);

    int insert(TbGood record);

    int insertSelective(TbGood record);

    List<TbGood> selectByExample(TbGoodExample example);

    TbGood selectByPrimaryKey(Integer goodId);

    int updateByExampleSelective(@Param("record") TbGood record, @Param("example") TbGoodExample example);

    int updateByExample(@Param("record") TbGood record, @Param("example") TbGoodExample example);

    int updateByPrimaryKeySelective(TbGood record);

    int updateByPrimaryKey(TbGood record);
}