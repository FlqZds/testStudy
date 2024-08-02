package com.ddjc.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content implements java.io.Serializable {
    private Integer contentId;

    private Integer type;

    private String imageurl;

    private String title;

    private String linkurl;

}