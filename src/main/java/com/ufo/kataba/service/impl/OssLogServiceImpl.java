package com.ufo.kataba.service.impl;

import com.ufo.kataba.dao.OssLogDao;
import com.ufo.kataba.entity.OssLog;
import com.ufo.kataba.service.intf.OssLogService;
import com.ufo.kataba.third.AliOssUtil;
import com.ufo.kataba.util.StrUtil;
import com.ufo.kataba.util.TokenUtil;
import com.ufo.kataba.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * projectName: Kataba
 * author: HDY
 * time: 2020/10/21 20:02
 * description:
 */
@Service
public class OssLogServiceImpl implements OssLogService {
    @Autowired
    private OssLogDao dao;

    @Override
    public R upload(String token, MultipartFile file) throws IOException {
        int uid= TokenUtil.getUid(token);
        if(!file.isEmpty()){
            //
            String fn=rename(file.getOriginalFilename());
            String url= AliOssUtil.uploadByte(AliOssUtil.BucketName,fn,file.getBytes());
            if(StrUtil.checkNoEmpty(url)){
                //持久化
                OssLog log=new OssLog(uid,AliOssUtil.BucketName,fn,1,new Date());
                dao.insert(log);
                return R.ok(url);
            }
        }
        return R.fail();
    }
    //文件名的处理
    private String rename(String f){
        //长度
        if (f.length()>50) {
           f = f.substring(f.length() - 50);
        }
        //重命名
        return UUID.randomUUID().toString().replace("-","")+"_"+f;

    }
}
