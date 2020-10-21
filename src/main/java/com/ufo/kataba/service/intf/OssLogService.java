package com.ufo.kataba.service.intf;

import com.ufo.kataba.vo.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 20:02
 * description:
 */
public interface OssLogService {
    //资源上传
    R upload(String token, MultipartFile file) throws IOException;
}
