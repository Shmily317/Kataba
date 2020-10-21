package com.ufo.kataba.service.intf;

import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:36
 * description:
 */
public interface AlbumLogService {
    //查询所有
    R query(int aid);
    //根据用户查询
    R queryAll(String token);
}
