package com.ufo.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ufo.kataba.dao.PictureLogDao;
import com.ufo.kataba.entity.PictureLog;
import com.ufo.kataba.service.intf.PictureLogService;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:24
 * description:
 */
@Service
public class PictureLogServiceImpl implements PictureLogService {
    @Autowired
    private PictureLogDao dao;
    //查询日志
    @Override
    public R query(int pid) {
        QueryWrapper<PictureLog> qw = new QueryWrapper<>();
        qw.eq("pid",pid);
        return R.ok(dao.selectList(qw));
    }
}
