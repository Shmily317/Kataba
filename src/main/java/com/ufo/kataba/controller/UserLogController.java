package com.ufo.kataba.controller;

import com.ufo.kataba.dto.UserDto;
import com.ufo.kataba.dto.UserLogDto;
import com.ufo.kataba.service.intf.UserLogService;
import com.ufo.kataba.service.intf.UserService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:22
 * description:
 */
@RestController
@RequestMapping("/api/userlog")
public class UserLogController {
    @Autowired
    private UserLogService service;

    @GetMapping("all.do")
    public R all(){
        return service.all();
    }

}
