package com.ufo.kataba.dto;

import lombok.Data;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:36
 * description:
 */
@Data
public class UserDto {
    private String phone;
    private String nname;   //昵称(账号)
    private String pwd;    //密码
}
