package com.yuwei.adsense.filter;

import com.yuwei.adsense.core.UserUtils;
import com.yuwei.adsense.exception.ShiroUsernamePasswordToken;
import com.yuwei.adsense.services.UserService;
import com.yuwei.adsense.shiro.SystemAuthorizingRealm;
import com.yuwei.adsense.util.RequestUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by YuWei on 2016/9/23.
 */
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

    public static final String DEFAULT_MESSAGE_PARAM = "msg";

    @Autowired
    private UserService userService;

   /*
    @Value("${local_pwd}")
    private String local_pwd;
*/

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {

        String username = getUsername(request);
        String password = getPassword(request);
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("FomrAuth:username:" + username + " password:" + password + "");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        if (password == null) {
            password = "";
        }
        boolean rememberMe = isRememberMe(request);

        String host = RequestUtils.getRemoteHost();
        boolean mobile = RequestUtils.isMobileLogin();
        return new ShiroUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, mobile);
    }

    /**
     * 登录成功之后跳转URL
     */
    @Override
    public String getSuccessUrl() {
        return super.getSuccessUrl();
    }

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        SystemAuthorizingRealm.Principal p = UserUtils.getPrincipal();
        if (p != null && !p.isMobileLogin()) {
            WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
        } else {
            super.issueSuccessRedirect(request, response);
        }
    }

    /**
     * 登录失败调用事件
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e,
                                     ServletRequest request,
                                     ServletResponse response) {
        String className = e.getClass().getName();
        String message;
        if (IncorrectCredentialsException.class.getName().equals(className)
                || UnknownAccountException.class.getName().equals(className)) {
            message = "用户或密码错误, 请重试.";
        } else if (e.getMessage() != null
                && org.apache.commons.lang3.StringUtils.startsWith(e.getMessage(), "msg:")) {
            message = org.apache.commons.lang3.StringUtils.replace(e.getMessage(), "msg:", "");
        } else {
            message = "系统出现问题，请稍后再试！";
            e.printStackTrace();
        }
        request.setAttribute(getFailureKeyAttribute(), className);
        request.setAttribute(DEFAULT_MESSAGE_PARAM, message);
        return true;
    }
}