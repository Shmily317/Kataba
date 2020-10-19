package com.ufo.kataba.service.intf;

import com.ufo.kataba.entity.User;
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
}
