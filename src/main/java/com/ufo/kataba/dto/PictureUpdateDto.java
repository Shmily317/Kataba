package com.ufo.kataba.dto;

import lombok.Data;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 19:53
 * description:
 */
@Data
public class PictureUpdateDto {
    private int id;
    private String title;
    private String info;
    private String iurl;
}