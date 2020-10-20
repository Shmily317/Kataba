package com.ufo.kataba.service.intf;

import com.ufo.kataba.dto.UserDto;
import com.ufo.kataba.dto.UserLogDto;
import com.ufo.kataba.entity.User;
import com.ufo.kataba.entity.UserLog;
import com.ufo.kataba.vo.R;

import java.util.List;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:40
 * description:
 */
public interface UserService {
   R<List<User>> all();

   //校验手机号
   R checkPhone(String phone);
   //校验昵称
   R checkName(String name);
   //注册
   R register (UserDto dto);
   //登陆
   R login(UserLogDto logDto);
   //找回密码
   R findPassword(UserDto userDto);


}
