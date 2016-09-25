package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Permission;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.PermissionDao;
import com.yuwei.adsense.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-25 21:39:29
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Long> implements PermissionService {
    private final static Logger LOG = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;

    public BaseDao<Permission, Long> getDao() {
        return permissionDao;
    }
}
