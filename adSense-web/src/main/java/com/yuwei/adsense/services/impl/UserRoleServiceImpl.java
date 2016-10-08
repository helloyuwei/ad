package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.UserRole;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.UserRoleDao;
import com.yuwei.adsense.services.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  <br />
 * @createTime 2016-9-25 21:39:31
 * @author template
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements UserRoleService {
    private final static Logger LOG = LoggerFactory
            .getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleDao userRoleDao;

    public BaseDao<UserRole, Long> getDao() {
        return userRoleDao;
    }
}
