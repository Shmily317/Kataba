package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.AlbumDto;
import com.ufo.kataba.dto.AlbumUpdateDto;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:36
 * description:
 */
public interface AlbumService {
    //新建
    R save(String token, AlbumDto dto);
    //修改
    R update(String token, AlbumUpdateDto dto);
    //查询
    R query(String token);
}
