package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.RolePermission;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.RolePermissionDao;
import com.yuwei.adsense.services.RolePermossionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  <br />
 * @createTime 2016-9-25 21:39:30
 * @author template
 */
@Service
public class RolePermossionServiceImpl extends BaseServiceImpl<RolePermission, Long> implements RolePermossionService {
    private final static Logger LOG = LoggerFactory
            .getLogger(RolePermossionServiceImpl.class);

    @Autowired
    private RolePermissionDao rolePermossionDao;

    public BaseDao<RolePermission, Long> getDao() {
        return rolePermossionDao;
    }
}
