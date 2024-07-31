package com.ddjc.teststudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbUser {
    private Long userId;

    private Long account;

    private String username;

    private String userpassword;

    private Integer roleId;

    private String nikname;

    private String roleName;

    private String avatarUrl;


}