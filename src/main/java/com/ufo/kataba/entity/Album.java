package com.ufo.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:28
 * description:相册表
 */
@Data
@TableName("t_album")
@NoArgsConstructor
public class Album {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private String title;
    private String info;
    private Integer type;
    private Date ctime;

    public Album(Integer uid, String title, String info, Integer type, Date ctime) {
        this.uid = uid;
        this.title = title;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
