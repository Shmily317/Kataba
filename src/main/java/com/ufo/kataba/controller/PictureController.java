package com.ufo.kataba.controller;

import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.dto.EmailDto;
import com.ufo.kataba.dto.PictureDto;
import com.ufo.kataba.dto.PictureUpdateDto;
import com.ufo.kataba.entity.Picture;
import com.ufo.kataba.service.intf.EmailLogService;
import com.ufo.kataba.service.intf.PictureService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 15:46
 * description:
 */
@RestController
@RequestMapping("/api/picture")
public class PictureController {
    @Autowired
    private PictureService service;

    //新增图片
    @PostMapping("/save.do")
    public R save(@RequestBody PictureDto dto, HttpServletRequest request){
        return service.save(request.getHeader(SystemConfig.TOKEN_HEADER),dto);
    }
    //查询图片 相册
    @GetMapping("queryByAId.do")
    public R queryByAId(int aid){

        return service.queryByAId(aid);
    }
    //修改
    @PutMapping("queryByAId.do")
    public R update(@RequestBody PictureUpdateDto dto){
        return service.update(dto);
    }
    //查询图片 单个
    @GetMapping("query.do")
    public R query(int id){

        return service.query(id);
    }

}
