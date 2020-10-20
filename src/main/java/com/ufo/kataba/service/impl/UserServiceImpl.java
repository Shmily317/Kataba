package com.ufo.kataba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ufo.kataba.config.RedisKeyConfig;
import com.ufo.kataba.dao.UserDao;
import com.ufo.kataba.dao.UserLogDao;
import com.ufo.kataba.dto.UserDto;
import com.ufo.kataba.dto.UserLogDto;
import com.ufo.kataba.entity.User;
import com.ufo.kataba.entity.UserLog;
import com.ufo.kataba.service.intf.UserService;
import com.ufo.kataba.third.JedisUtil;
import com.ufo.kataba.third.JwtUtil;
import com.ufo.kataba.util.EncryptUtil;
import com.ufo.kataba.util.StrUtil;
import com.ufo.kataba.vo.R;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/19 17:41
 * description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogDao logDao;
    @Value("${kataba.passkey}")
    private String pk;

    @Override
    public R<List<User>> all() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        return R.ok(userDao.selectList(qw));
    }

    /**
     * 校验手机号
     * @param phone
     * @return
     */
    @Override
    public R checkPhone(String phone) {
        if (StrUtil.checkNoEmpty(phone)){
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("phone",phone);
            if (userDao.selectOne(qw)!=null) {
                //存在
                return R.fail();
            }else {
                //不存在-可用
                return R.ok();
            }
        }

        return R.fail();
    }

    /**
     *校验昵称
     * @param name
     * @return
     */
    @Override
    public R checkName(String name) {
        if (StrUtil.checkNoEmpty(name)){
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("nickname",name);
            if (userDao.selectOne(qw)!=null) {
                //存在
                return R.fail();
            }else {
                //不存在-可用
                return R.ok();
            }
        }
        return R.fail();
    }

    /**
     * 注册
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public R register(UserDto dto) {
        //校验是否可用
        User user = userDao.selectByNamePhone(dto.getNname(),dto.getPhone());
        if (user == null) {
            //密码 密文 aes
            dto.setPwd(EncryptUtil.aesdec(pk,dto.getPwd()));
            //新增
            User u = new User(dto.getPhone(),dto.getPwd(),dto.getNname(),1);
            if (userDao.insert(user) > 0){
                //记录日志
                UserLog userLog = new UserLog(user.getId(),1,"注册新用户",new Date());
                logDao.insert(userLog);
                return R.ok();
            }
        }
        return R.fail();
    }

    /**
     * 登陆
     * @param logDto
     * @return
     */
    @Override
    public R login(UserLogDto logDto) {
        //1.校验
        User user = userDao.selectByName(logDto.getName());
        if (user!=null) {
            //2.比较密码 密文比较
            if (EncryptUtil.aesenc(pk,logDto.getPwd()).equals(user.getPassword())){
                //密码一致
                //3.成功之后生成令牌
                String token = JwtUtil.createToken(user.getPhone());
                //4.存储令牌
                //记录令牌 对应的用户
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_TOKEN+token,RedisKeyConfig.LOGIN_TIME,new JSONObject(user).toString());
                //记录登陆过的账号信息
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_USER+user.getId(),RedisKeyConfig.LOGIN_TIME,token);
                //5.返回结果
                return R.ok(token);
            }
        }
        return R.fail();
    }

    /**
     * 找回密码
     * @param userDto
     * @return
     */
    @Override
    public R findPassword(UserDto userDto) {
        return null;
    }
}
