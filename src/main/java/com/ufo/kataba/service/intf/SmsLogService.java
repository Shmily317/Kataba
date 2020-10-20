package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.SmsRCodeDto;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:45
 * description:
 */
public interface SmsLogService {
    //发送短信验证码
    R sendRCode (String phone);
    //验证验证码
    R checkRCode(SmsRCodeDto dto);
}
