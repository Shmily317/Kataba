package com.ufo.kataba.controller;

import com.ufo.kataba.dto.EmailDto;
import com.ufo.kataba.entity.EmailLog;
import com.ufo.kataba.service.intf.EmailLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 15:46
 * description:
 */
@RestController
@RequestMapping("/api/email")
public class EmailLogController {
    @Autowired
    private EmailLogService service;

    //发送邮箱验证码
    @PostMapping("/sendRCode.do")
    public R sendRCode(@RequestBody EmailDto dto){
        return service.save(dto);
    }
    //校验邮箱验证码
    @PostMapping("all.do")
    public R checkRCode(){

        return service.all();
    }

}
