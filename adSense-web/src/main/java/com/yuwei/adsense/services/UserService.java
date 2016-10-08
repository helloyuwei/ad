package com.yuwei.adsense.services;

import com.yuwei.adsense.core.entity.Permission;
import com.yuwei.adsense.core.entity.Role;
import com.yuwei.adsense.core.entity.User;

import java.util.List;

/**
 * Created by YuWei on 2016/9/23.
 */
public interface UserService extends BaseService<User, Long> {
    User getByUsername(String loginName);

    List<Permission> listPermissions(Long roleId);

    List<Role> listRoles(Long userId);
}
