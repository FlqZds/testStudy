package com.ddjc.teststudy.service;


import com.ddjc.teststudy.beans.menuDTO;
import com.ddjc.teststudy.common.Exception.AppException;
import com.ddjc.teststudy.common.RESTFUL.ResponseEnum;
import com.ddjc.teststudy.mapper.RoleRightMapper;
import com.ddjc.teststudy.mapper.TbActionrightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rbacService {

    @Autowired
    private RoleRightMapper roleRightMapper;

    //根据角色ID查询角色拥有的菜单权限
    //生成父级菜单 - 子级菜单的树形结构
    public List<menuDTO> generateMenuTree(Integer roleId) {

        //根据角色ID查询角色拥有的菜单权限 - 父级菜单
        List<menuDTO> menuDTO_father_list = roleRightMapper.selectByRoleIDAndParentID(roleId, 0);

        if(menuDTO_father_list.size() <= 0 || menuDTO_father_list == null){
            throw new AppException(ResponseEnum.USER_ROLE_NOT_EXIST);
        }


        //根据父级菜单查询子级菜单 - 子级菜单的树形结构

        for(menuDTO father_menu : menuDTO_father_list){
            //根据父级菜单ID查询子级菜单
            List<menuDTO> menuDTO_son_list = roleRightMapper.selectByRoleIDAndParentID(roleId, father_menu.getRightid());
            father_menu.setChildren(menuDTO_son_list); //存储子级菜单到父级菜单中  也就是存到 menuDTO的children属性中
        }
        ;
        //返回父级菜单的树形结构
        return menuDTO_father_list;
    }


    @Autowired
    private TbActionrightMapper actionrightMapper;
    //根据角色ID查询角色拥有的动作权限码
    public List<String> selectActionCodeByRoleID(Integer roleId) {
        return actionrightMapper.selectRightCODEByRoleID(roleId);
    }

}
