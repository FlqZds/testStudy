package com.ddjc.teststudy.mapper;

import com.ddjc.teststudy.entity.RoleActionRight;
import com.ddjc.teststudy.entity.RoleActionRightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleActionRightMapper {
    int countByExample(RoleActionRightExample example);

    int deleteByExample(RoleActionRightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleActionRight record);

    int insertSelective(RoleActionRight record);

    List<RoleActionRight> selectByExample(RoleActionRightExample example);

    RoleActionRight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleActionRight record, @Param("example") RoleActionRightExample example);

    int updateByExample(@Param("record") RoleActionRight record, @Param("example") RoleActionRightExample example);

    int updateByPrimaryKeySelective(RoleActionRight record);

    int updateByPrimaryKey(RoleActionRight record);
}