package com.ufo.kataba.util;

import java.util.Random;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 17:11
 * description:随机验证码
 */
public class NumRandomUtil {

    //随机生成数字，指定位数
    public static int randomNum(int len){
        Random random = new Random();
        double d = Math.pow(10,len-1);
        return random.nextInt((int)(Math.pow(10,len)-d))+(int)d;
    }
}
