package com.ddjc.teststudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbRight {
    private Integer rightid;

    private String righttext;

    private Integer righttype;

    private String righturl;

    private Integer parentid;

    private Boolean isMenu;

}