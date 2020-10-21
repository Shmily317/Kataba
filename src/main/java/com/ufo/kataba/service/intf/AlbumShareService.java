package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.AlbumShareDto;
import com.ufo.kataba.vo.R;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:36
 * description:
 */
public interface AlbumShareService {
    //创建分享
    R save(String token, AlbumShareDto dto);
    //修改 停止分享
    R stopShare(int id);
}
