package com.ufo.kataba.service.impl;

import com.ufo.kataba.config.RedisKeyConfig;
import com.ufo.kataba.dao.SmsLogDao;
import com.ufo.kataba.dto.SmsRCodeDto;
import com.ufo.kataba.service.intf.SmsLogService;
import com.ufo.kataba.third.JedisUtil;
import com.ufo.kataba.third.SmsUtil;
import com.ufo.kataba.util.NumRandomUtil;
import com.ufo.kataba.util.StrUtil;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:55
 * description:
 */
@Service
public class SmsLogServiceImpl implements SmsLogService {
    @Autowired
    private SmsLogDao smsLogDao;

    /**
     * 发送短信验证码
     *
     * @param phone
     * @return
     */
    @Override
    public R sendRCode(String phone) {
        //生成验证码
        int code = NumRandomUtil.randomNum(6);
        //发送验证码
        if (SmsUtil.sendRCode(phone, code)) {
            //存储验证码
            JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.SMS_RCODE + phone, RedisKeyConfig.RCODE_TIME, code + "");
            //结果返回
            return R.ok();
        }
        return R.fail();
    }

    /**
     * 验证验证码
     *
     * @param dto
     * @return
     */
    @Override
    public R checkRCode(SmsRCodeDto dto) {
        if (StrUtil.checkNoEmpty(dto.getPhone())) {
            String k = RedisKeyConfig.SMS_RCODE + dto.getPhone();
            //校验验证码是否失效
            if (JedisUtil.getInstance().getJedis().exists(k)) {
                //验证码是否一致
                if (dto.getCode() == Integer.parseInt(JedisUtil.getInstance().STRINGS.get(k))) {
                    return R.ok();
                }
            }
        }
        return R.fail();
    }
}
