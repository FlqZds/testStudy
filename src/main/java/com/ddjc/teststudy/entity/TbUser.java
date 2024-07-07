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
    private Integer userId;

    private Long account;

    private String username;

    private String userpassword;

    private String nikname;


}