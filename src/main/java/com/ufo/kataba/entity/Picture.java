package com.ufo.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 19:53
 * description:
 */
@Data
@TableName("t_picture")
@NoArgsConstructor
public class Picture {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String info;
    private String iurl;
    private Integer flag;
    private Integer aid;
    private Integer uid;

    public Picture(String title, String info, String iurl, Integer flag, Integer aid, Integer uid) {
        this.title = title;
        this.info = info;
        this.iurl = iurl;
        this.flag = flag;
        this.aid = aid;
        this.uid = uid;
    }
}