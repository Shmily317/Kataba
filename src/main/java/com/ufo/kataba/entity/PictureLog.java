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
 * time: 2020/10/21 19:53
 * description:
 */

@Data
@TableName("t_picturelog")
@NoArgsConstructor
public class PictureLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String info;
    private Integer flag;
    private Date ctime;

    public PictureLog(Integer pid, String info, Integer flag, Date ctime) {
        this.pid = pid;
        this.info = info;
        this.flag = flag;
        this.ctime = ctime;
    }
}