package com.ddjc.teststudy.mapper;

import com.ddjc.teststudy.entity.TbActionright;
import com.ddjc.teststudy.entity.TbActionrightExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbActionrightMapper {
    int countByExample(TbActionrightExample example);

    int deleteByExample(TbActionrightExample example);

    int deleteByPrimaryKey(Integer rightid);

    int insert(TbActionright record);

    int insertSelective(TbActionright record);

    List<TbActionright> selectByExample(TbActionrightExample example);

    TbActionright selectByPrimaryKey(Integer rightid);

    int updateByExampleSelective(@Param("record") TbActionright record, @Param("example") TbActionrightExample example);

    int updateByExample(@Param("record") TbActionright record, @Param("example") TbActionrightExample example);

    int updateByPrimaryKeySelective(TbActionright record);

    int updateByPrimaryKey(TbActionright record);

    //根据roleID查出当前角色的权限码
    List<String> selectRightCODEByRoleID(Integer roleID);
}