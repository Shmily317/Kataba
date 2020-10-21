package com.ufo.kataba.controller;

import com.ufo.kataba.dto.UserDto;
import com.ufo.kataba.dto.UserLogDto;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserService userService;

    @GetMapping("/all.do")
    public R all(){
        return userService.all();
    }
    //校验
    @GetMapping("checkphone.do")
    public R checkP(String phone){
        return service.checkPhone(phone);
    }
    @GetMapping("checknickname.do")
    public R checkN(String name){
        return service.checkName(name);
    }
    @PostMapping("register.do")
    public R save(@RequestBody UserDto dto){
        return service.register(dto);
    }
    @PostMapping("/login.do")
    public R login(@RequestBody UserLogDto loginDto){
        return service.login(loginDto);
    }
}
