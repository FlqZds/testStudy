package com.ddjc.teststudy.beans;


import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class user {
    private String userName;

    private String userPassword;
    @Singular(value = "userAddress")
    private List<String> userAddress;

}
