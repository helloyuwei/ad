package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.User;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.UserDao;
import com.yuwei.adsense.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YuWei on 2016/9/23.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserDao userDao;

    public BaseDao<User, Long> getDao() {
        return userDao;
    }

    public User getByUsername(String loginName) {
        return userDao.getByUsername(loginName);
    }
}
