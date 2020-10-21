package com.ufo.kataba.controller;

import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.dto.AlbumDto;
import com.ufo.kataba.dto.AlbumUpdateDto;
import com.ufo.kataba.service.intf.AlbumLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 17:44
 * description:
 */
@RestController
@RequestMapping("/api/albumlog")
public class AlbumLogController {
    @Autowired
    private AlbumLogService service;
    //查询
    @GetMapping("/all.do")
    public R all(HttpServletRequest request) {
        return service.queryAll(request.getHeader(SystemConfig.TOKEN_HEADER));
    }
}


