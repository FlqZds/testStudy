package com.ddjc.teststudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbGood {
    private Integer goodId;

    private String name;

    private Long price;

    private String des;

    private Integer typeId;


}