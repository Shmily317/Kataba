package com.ufo.kataba.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ufo.kataba.dto.UserDto;
import com.ufo.kataba.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:29
 * description:
 */
@Repository
public interface UserDao extends BaseMapper<User> {
    @Select("select * from t_user where nickname = #{n} or phone = #{n}")
    @ResultType(User.class)
    User selectByName(String n);

    @Select("select * from t_user where nickname = #{n} or phone = #{p}")
    @ResultType(User.class)
    User selectByNamePhone(@Param("n") String n, @Param("p") String p);

    @Insert("insert into t_user (nickname,phone,password,flag) values(#{nname},#{phone},#{pwd},1)")
    int insertDto(UserDto dto);

}
