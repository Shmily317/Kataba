package com.ufo.kataba.util;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:44
 * description:字符串校验
 */
public class StrUtil {
    /**
     * continue; 跳出本次循环，结束本次循环
     * break;    跳出当前最近的循环，结束最近的循环体
     * return ;  结束方法
     *
     * 校验是否为空
     * @param strs
     * @return true 非空   false 空
     */
    public static boolean checkEmpty(String... strs) {
        boolean r = true;
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                r = false;
                break;
            }
        }
        return r;
    }
}
