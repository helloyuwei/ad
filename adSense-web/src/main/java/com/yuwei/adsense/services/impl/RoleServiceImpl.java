package com.yuwei.adsense.services.impl;


import com.yuwei.adsense.core.entity.Role;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.RoleDao;
import com.yuwei.adsense.dao.SiteDao;
import com.yuwei.adsense.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-25 21:39:29
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public BaseDao<Role, Long> getDao() {
        return roleDao;
    }
}
