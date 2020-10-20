package com.ufo.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:41
 * description:
 */
@Data
@TableName("t_smslog")
public class SmsLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private Integer type;
    private String content;
    private Date ctime;
}
