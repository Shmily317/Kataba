package com.ufo.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ufo.kataba.config.RedisKeyConfig;
import com.ufo.kataba.dao.AlbumDao;
import com.ufo.kataba.dao.AlbumLogDao;
import com.ufo.kataba.dto.AlbumDto;
import com.ufo.kataba.dto.AlbumUpdateDto;
import com.ufo.kataba.entity.Album;
import com.ufo.kataba.entity.AlbumLog;
import com.ufo.kataba.service.intf.AlbumService;
import com.ufo.kataba.third.JedisUtil;
import com.ufo.kataba.util.TokenUtil;
import com.ufo.kataba.vo.R;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:37
 * description:
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao dao;
    @Autowired
    private AlbumLogDao logDao;

    //新建
    @Override
    @Transactional//开启事物
    public R save(String token, AlbumDto dto) {
        //获取用户id
        int uid = TokenUtil.getUid(token);
        //实例化相册对象
        Album album = new Album(uid, dto.getTitle(), dto.getInfo(), dto.getType(), new Date());
        //新增相册
        if (dao.insert(album) > 0) {
            //实例化日志
            AlbumLog albumLog = new AlbumLog(album.getId(), uid + "创建相册", 1, new Date());
            logDao.insert(albumLog);
            return R.ok();
        }
        return R.fail();
    }

    //修改
    @Override
    public R update(String token, AlbumUpdateDto dto) {
        int uid = TokenUtil.getUid(token);
        if (dao.updateTitle(dto) > 0) {
            //实例化日志
            AlbumLog albumLog = new AlbumLog(dto.getId(), "修改相册", 2, new Date());
            logDao.insert(albumLog);
            return R.ok();
        }

        return R.fail();
    }

    //查询
    @Override
    public R query(String token) {
        int uid = TokenUtil.getUid(token);
        QueryWrapper<Album> qw = new QueryWrapper<>();
        qw.eq("uid", uid);
        qw.orderByDesc("ctime");
        return R.ok(dao.selectList(qw));
    }
}
