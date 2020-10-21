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
 * time: 2020/10/21 11:25
 * description:相册操作日志表
 */
@Data
@TableName("t_albumlog")
@NoArgsConstructor
public class AlbumLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer aid;
    private String info;
    private Integer type;
    private Date ctime;

    public AlbumLog(Integer aid, String info, Integer type, Date ctime) {
        this.aid = aid;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
