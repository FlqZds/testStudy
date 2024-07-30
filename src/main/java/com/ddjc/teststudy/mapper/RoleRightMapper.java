package com.ddjc.teststudy.mapper;

import com.ddjc.teststudy.beans.menuDTO;
import com.ddjc.teststudy.entity.RoleRight;
import com.ddjc.teststudy.entity.RoleRightExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRightMapper {
    int countByExample(RoleRightExample example);

    int deleteByExample(RoleRightExample example);

    int deleteByPrimaryKey(Integer rrid);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    List<RoleRight> selectByExample(RoleRightExample example);

    RoleRight selectByPrimaryKey(Integer rrid);

    int updateByExampleSelective(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByExample(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);

    //通过roleID,parentID查询 该角色的权限
    //-- 该方法用于菜单树的展示  先查询父级菜单，在子级菜单
    List<menuDTO> selectByRoleIDAndParentID(@Param("roleID") Integer roleID, @Param("parentID") Integer parentID);
}