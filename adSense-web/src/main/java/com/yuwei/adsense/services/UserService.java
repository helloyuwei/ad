package com.yuwei.adsense.services;

import com.yuwei.adsense.core.entity.User;

/**
 * Created by YuWei on 2016/9/23.
 */
public interface UserService extends BaseService<User, Long> {
    User getByUsername(String loginName);
}
