package com.ufo.kataba.test;

import com.ufo.kataba.util.EncryptUtil;
import org.junit.jupiter.api.Test;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 20:19
 * description:秘钥
 */
public class Pass_Test {
    @Test
    public void t1(){
        String key = EncryptUtil.createAESKey();
        System.out.println(key);
        String pass="123456";
        String mw = EncryptUtil.aesenc(key, pass);
        System.out.println(mw);
        System.out.println(EncryptUtil.aesdec(key,mw));

    }
}
