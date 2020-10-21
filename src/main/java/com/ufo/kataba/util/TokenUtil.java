package com.ufo.kataba.util;

import com.ufo.kataba.config.RedisKeyConfig;
import com.ufo.kataba.third.JedisUtil;
import org.json.JSONObject;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 17:13
 * description:令牌
 */
public class TokenUtil {
    //获取用户id
    public static int getUid(String token){
        return new JSONObject(JedisUtil.getInstance().STRINGS.
                get(RedisKeyConfig.LOGIN_TOKEN+token)).getInt("id");
    }
}

