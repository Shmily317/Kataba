package com.ufo.kataba.controller;

import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.dto.AlbumDto;
import com.ufo.kataba.dto.AlbumUpdateDto;
import com.ufo.kataba.service.intf.AlbumService;
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
@RequestMapping("/api/album")
public class AlbumController {
    @Autowired
    private AlbumService service;

    //新增
    @PostMapping("/save.do")
    public R save(@RequestBody AlbumDto dto, HttpServletRequest request) {
        return service.save(request.getHeader(SystemConfig.TOKEN_HEADER), dto);
    }

    //修改
    @PutMapping("/update.do")
    public R update(@RequestBody AlbumUpdateDto dto, HttpServletRequest request) {
        return service.update(request.getHeader(SystemConfig.TOKEN_HEADER), dto);
    }

    //查询
    @GetMapping("/query.do")
    public R query(HttpServletRequest request) {
        return service.query(request.getHeader(SystemConfig.TOKEN_HEADER));
    }
}
