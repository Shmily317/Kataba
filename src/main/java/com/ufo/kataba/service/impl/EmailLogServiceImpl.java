package com.ufo.kataba.service.impl;

import com.ufo.kataba.dao.EmailLogDao;
import com.ufo.kataba.dto.EmailDto;
import com.ufo.kataba.entity.EmailLog;
import com.ufo.kataba.service.intf.EmailLogService;
import com.ufo.kataba.util.EmailUtil;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/22 11:24
 * description:
 */
@Service
public class EmailLogServiceImpl implements EmailLogService {
    @Autowired
    private EmailLogDao logDao;
    //新增
    @Override
    public R save(EmailDto dto) {
        if (EmailUtil.sendEmail(dto.getEmail(),dto.getTitle(),dto.getContent())) {
            EmailLog emailLog = new EmailLog(1,dto.getContent(),dto.getTitle(),dto.getEmail(),new Date() );
            logDao.insert(emailLog);
            return R.ok();
        }
        return R.fail();
    }
    //查询
    @Override
    public R all() {

        return R.ok(logDao.selectList(null));
    }
}
