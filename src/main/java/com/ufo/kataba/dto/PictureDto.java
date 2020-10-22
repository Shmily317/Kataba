package com.ufo.kataba.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 19:53
 * description:
 */
@Data
public class PictureDto {
    private String title;
    private String info;
    private String iurl;
    private Integer aid;
}