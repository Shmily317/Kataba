package com.ufo.kataba.service.impl;

import com.ufo.kataba.dao.UserLogDao;
import com.ufo.kataba.entity.UserLog;
import com.ufo.kataba.service.intf.UserLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/20 16:52
 * description:日志
 */
@Service
public class UserLogServiceImpl  implements UserLogService {
    @Autowired
    private UserLogDao logDao;

    @Override
    public R save(UserLog log) {
        return null;
    }

    @Override
    public R all() {
        return R.ok(logDao.selectList(null));
    }
}
