package com.ufo.kataba.core.type;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:24
 * description:枚举类型
 */
public enum  RType {
    成功(1),失败(2),登陆失败(3);


    private int val;
    public int getVal() {
        return val;
    }
    private RType(int v) {
        val = v;
    }
}
