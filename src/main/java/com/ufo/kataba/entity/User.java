package com.ufo.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:31
 * description:
 */
@Data
@TableName("t_user")
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String nickname;
    private String password;
    private int flag;//标记  1有效    2无效

    public User(String phone, String nickname, String password, int flag) {
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.flag = flag;
    }
}
