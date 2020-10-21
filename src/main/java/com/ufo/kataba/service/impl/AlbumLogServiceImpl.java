package com.ufo.kataba.service.impl;

import com.ufo.kataba.dao.AlbumLogDao;
import com.ufo.kataba.service.intf.AlbumLogService;
import com.ufo.kataba.util.TokenUtil;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:37
 * description:
 */
@Service
public class AlbumLogServiceImpl implements AlbumLogService {
    @Autowired
    private AlbumLogDao dao;

    @Override
    public R query(int aid) {
        return R.ok();
    }

    @Override
    public R queryAll(String token) {
        int uid = TokenUtil.getUid(token);
        return R.ok(dao.all(uid));
    }
}
