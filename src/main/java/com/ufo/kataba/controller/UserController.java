package com.ufo.kataba.controller;

import com.ufo.kataba.service.intf.UserService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:22
 * description:
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all.do")
    public R all(){
        return userService.all();
    }
}
