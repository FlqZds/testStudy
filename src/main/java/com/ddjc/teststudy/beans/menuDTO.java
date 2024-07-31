package com.ddjc.teststudy.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class menuDTO {
    private Integer rightid;

    private String righttext;

    private Integer righttype;

    private String righturl; // 权限路由

    private Integer parentid;

    private Boolean isMenu;

    private List<menuDTO> children; //存储 子菜单 的集合
}
