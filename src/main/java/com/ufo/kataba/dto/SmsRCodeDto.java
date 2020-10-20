package com.ufo.kataba.dto;

import lombok.Data;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:48
 * description:
 */
@Data
public class SmsRCodeDto {
    private String phone;
    private int code;
}
