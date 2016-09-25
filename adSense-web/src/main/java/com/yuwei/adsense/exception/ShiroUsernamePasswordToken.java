package com.yuwei.adsense.exception;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by YuWei on 2016/9/23.
 */
public class ShiroUsernamePasswordToken extends UsernamePasswordToken {
    private Boolean isMobile;

    public ShiroUsernamePasswordToken(String username, final char[] password, boolean rememberMe, String host, Boolean isMobile) {
        super(username, password, rememberMe, host);
        this.isMobile = isMobile;
    }
}
