package com.yuwei.adsense.dao;

import com.yuwei.adsense.core.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by YuWei on 2016/9/23.
 */
public interface UserDao extends BaseDao<User, Long> {
    User getByUsername(@Param("loginName") String loginName);
}
