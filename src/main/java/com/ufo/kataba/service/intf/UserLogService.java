package com.ufo.kataba.service.intf;

import com.ufo.kataba.entity.UserLog;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:52
 * description:日志
 */
public interface UserLogService {
    //新增
    R save(UserLog log);
    //查询

}
