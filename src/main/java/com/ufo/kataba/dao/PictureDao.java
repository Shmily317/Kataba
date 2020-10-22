package com.ufo.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ufo.kataba.dto.PictureUpdateDto;
import com.ufo.kataba.entity.Picture;
import com.ufo.kataba.entity.PictureLog;
import org.springframework.stereotype.Repository;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:20
 * description:
 */
@Repository
public interface PictureDao extends BaseMapper<Picture> {
    int updateInfo(PictureUpdateDto dto);
}
