package com.ufo.kataba.controller;

import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.service.intf.AlbumLogService;
import com.ufo.kataba.service.intf.PictureLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 17:44
 * description:
 */
@RestController
@RequestMapping("/api/ picturepog")
public class PictureLogController {
    @Autowired
    private PictureLogService service;
    //查询日志
    @GetMapping("/query.do")
    public R query(int pid) {
        return service.query(pid);
    }
}


