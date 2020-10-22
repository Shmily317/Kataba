package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.PictureDto;
import com.ufo.kataba.dto.PictureUpdateDto;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:24
 * description:
 */
public interface PictureService {
    //新增图片
    R save(String token,PictureDto dto);
    //查询图片 相册
    R queryByAId(int aid);
    //修改
    R update(PictureUpdateDto dto);
    //查询图片 单个
    R query(int id);

}
