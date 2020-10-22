package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.EmailDto;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:24
 * description:
 */
public interface EmailLogService {
    //新增
    R save(EmailDto dto);
    //查询
    R all();

}
