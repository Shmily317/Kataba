package com.ufo.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ufo.kataba.dto.AlbumUpdateDto;
import com.ufo.kataba.entity.Album;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:32
 * description:
 */
@Repository
public interface AlbumDao extends BaseMapper<Album> {
    @Update("update t_album set title=#{title},info=#{info}where id =#{id}")
    int updateTitle(AlbumUpdateDto dto);
}
