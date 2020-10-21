package com.ufo.kataba.controller;

import com.ufo.kataba.config.SystemConfig;
import com.ufo.kataba.service.intf.OssLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 20:17
 * description:
 */
@RestController
@RequestMapping("/api/oss")
public class OssLogController {
    @Autowired
    private OssLogService service;

    @PostMapping("upload.do")
    public R upload(MultipartFile file, HttpServletRequest request) throws IOException {
        return service.upload(request.getHeader(SystemConfig.TOKEN_HEADER),file);

    }
}
