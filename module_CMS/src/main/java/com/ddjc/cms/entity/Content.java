package com.ddjc.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private Integer contentId;

    private Integer type;

    private String imageurl;

    private String title;

    private String linkurl;

}