package com.yuwei.adsense.dao;

import com.yuwei.adsense.core.entity.Role;

import java.util.List;

/**
 * Created by YuWei on 2016/9/30.
 */
public interface RoleDao extends BaseDao<Role, Long> {
    List<Role> listRoles(Long userId);
}
