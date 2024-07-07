package com.ddjc.teststudy.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDTO {
    private Long userId;
    private Integer roleId;
    private String username; //用户名
    private String account; //账号
    private String nikname; //昵称
    private String avatarUrl; //头像
    private String token;

}
