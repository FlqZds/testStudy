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

    private Long account;

    private String username;

    private String userpassword;

    private Integer roleId;

    private String nikname;

    private String roleName;

    private String avatarUrl;

    private String token; //校验令牌

}
