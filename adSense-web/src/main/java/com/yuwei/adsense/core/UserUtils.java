package com.yuwei.adsense.core;

import com.yuwei.adsense.shiro.SystemAuthorizingRealm;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * Created by YuWei on 2016/9/23.
 */
public class UserUtils {
    private static MappedStatement session;
    private static SystemAuthorizingRealm.Principal principal;

    public static MappedStatement getSession() {
        return session;
    }

    public static SystemAuthorizingRealm.Principal getPrincipal() {
        return principal;
    }
}
