package com.ufo.kataba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ufo.kataba.entity.AlbumLog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 11:33
 * description:
 */
@Repository
public interface AlbumLogDao extends BaseMapper<AlbumLog> {

    @Select("select al.* from t_albumlog al inner join t_album a on a.id = al.aid where  a.uid = #{uid};")
    List<AlbumLog> all(int uid);
}
