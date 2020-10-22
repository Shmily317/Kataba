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
@TableName("t_emaillog")
@NoArgsConstructor
public class EmailLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private String content;
    private String title;
    private String email;
    private Date ctime;

    public EmailLog(Integer type, String content, String title, String email, Date ctime) {
        this.type = type;
        this.content = content;
        this.title = title;
        this.email = email;
        this.ctime = ctime;
    }
}