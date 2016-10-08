package com.yuwei.adsense.shiro;

import com.yuwei.adsense.core.UserUtils;
import com.yuwei.adsense.core.entity.Role;
import com.yuwei.adsense.core.entity.User;
import com.yuwei.adsense.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuWei on 2016/9/23.
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String) super.getAvailablePrincipal(principals);

        List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();

        getRolesAndPermissions(currentUsername, roleList, permissionList);

        //为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);
        simpleAuthorInfo.addStringPermissions(permissionList);

        System.out.println("开始授权");
        return info;
    }

    private void getRolesAndPermissions(String currentUsername, List<String> roleList, List<String> permissionList) {
        //从数据库中获取当前登录用户的详细信息
        User user = userService.getByUsername(currentUsername);
        List<Role> roles = userService.listRoles(user.getId());
        user.setRoles(roles);
        if (null != user) {
            //实体类User中包含有用户角色的实体类信息
            if (null != user.getRoles() && user.getRoles().size() > 0) {
                //获取当前登录用户的角色
                for (Role role : user.getRoles()) {
                    roleList.add(role.getName());
                    //实体类Role中包含有角色权限的实体类信息
                    if (null != role.getPermissions() && role.getPermissions().size() > 0) {
                        //获取权限
                        for (com.yuwei.adsense.core.entity.Permission pmss : role.getPermissions()) {
                            if (!StringUtils.isEmpty(pmss.getPermission())) {
                                permissionList.add(pmss.getPermission());
                            }
                        }
                    }
                }
            }
        } else {
            throw new AuthorizationException();
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        User user = userService.getByUsername(username);

        System.out.println("===========");
        if (null != user) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), user.getNickName());
            this.setSession("currentUser", user);
            return authcInfo;
        } else {
            return null;
        }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }

    public static class Principal implements Serializable {
        private static final long serialVersionUID = 1L;

        private Long id; // 编号

        private String loginName; // 登录名

        private String name; // 姓名

        private Boolean mobileLogin;

        public Principal(User user) {
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.name = user.getNickName();
        }

        public Long getId() {

            return id;
        }

        public String getLoginName() {
            return loginName;
        }

        public String getName() {
            return name;
        }

        /**
         * 获取SESSIONID
         */

        public String getSessionid() {
            try {
                return (String) UserUtils.getSession().getId();
            } catch (Exception e) {
                return "";
            }
        }

        public Boolean isMobileLogin() {
            return mobileLogin;
        }

        public void setMobileLogin(Boolean mobileLogin) {
            this.mobileLogin = mobileLogin;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

}