package com.ufo.kataba.controller;

import com.ufo.kataba.dto.SmsRCodeDto;
import com.ufo.kataba.service.intf.SmsLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:39
 * description:短信验证
 */
@RestController
@RequestMapping("/api/sms")
public class SmsController {
    @Autowired
    private SmsLogService smsLogService;
    //发送短信验证
    @PostMapping("/sendrcode.do")
    public R sendRCode( String phone){
        return smsLogService.sendRCode(phone);
    }
    //校验短信验证
    @PostMapping("/checkRCode.do")
    public R checkRCode(@RequestBody SmsRCodeDto dto){
        return smsLogService.checkRCode(dto);
    }

}
