package com.ufo.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ufo.kataba.dao.PictureDao;
import com.ufo.kataba.dao.PictureLogDao;
import com.ufo.kataba.dto.PictureDto;
import com.ufo.kataba.dto.PictureUpdateDto;
import com.ufo.kataba.entity.Picture;
import com.ufo.kataba.entity.PictureLog;
import com.ufo.kataba.service.intf.PictureService;
import com.ufo.kataba.util.TokenUtil;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:24
 * description:
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao dao;
    //日志
    @Autowired
    private PictureLogDao logDao;
    //新增图片
    @Override
    @Transactional//开启事物
    public R save(String token,PictureDto dto) {
        int uid = TokenUtil.getUid(token);
        Picture picture = new Picture(dto.getTitle(),dto.getInfo(),dto.getIurl(),1,dto.getAid(),uid);
        dao.insert(picture);
        PictureLog pictureLog = new PictureLog(picture.getId(),"新增相册"+uid,1,new Date());
        logDao.insert(pictureLog);
        return R.ok();
    }
    //查询图片 相册
    @Override
    public R queryByAId(int aid) {
        QueryWrapper<Picture> qw = new QueryWrapper<>();
        qw.eq("aid",aid);
        qw.orderByDesc("id");
        return R.ok(dao.selectList(qw));
    }
    //修改
    @Override
    @Transactional
    public R update(PictureUpdateDto dto) {
        if (dao.updateInfo(dto)>0){
            PictureLog pictureLog = new PictureLog(dto.getId(),"修改了相册",1,new Date());
            logDao.insert(pictureLog);
            return R.ok();
        }else {
            return R.fail();
        }
    }
    //查询图片 单个
    @Override
    public R query(int id) {
        return R.ok(dao.selectById(id));
    }
}
