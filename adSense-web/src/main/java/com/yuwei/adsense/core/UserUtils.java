package com.yuwei.adsense.core;

import com.yuwei.adsense.common.Global;
import com.yuwei.adsense.core.entity.User;
import com.yuwei.adsense.shiro.SystemAuthorizingRealm;
import com.yuwei.adsense.util.MD5;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by YuWei on 2016/9/23.
 */
public class UserUtils {
    private static MappedStatement session;
    private static SystemAuthorizingRealm.Principal principal;

    private static int TOKEN_TIME_INDEX = 42;

    public static MappedStatement getSession() {
        return session;
    }

    public static SystemAuthorizingRealm.Principal getPrincipal() {
        return principal;
    }

    public static String generateRestPasswordToken(User user) {
        if (user == null) {
            return null;
        }
        StringBuilder token = new StringBuilder();
        token.append(MD5.md5(user.getLoginName()).substring(0, 10));
        token.append(RandomStringUtils.randomAlphanumeric(32));
        try {
            Long currentTimeMillis = new Date().getTime();
            System.out.println(currentTimeMillis);
            byte[] currentTime = String.valueOf(currentTimeMillis).getBytes("utf-8");
            token.append(new BASE64Encoder().encode(currentTime));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token.toString();
    }


    public static Long getResetPasswordTime(String token) {
        if (StringUtils.isEmpty(token)) {
            return 0L;
        }
        String tokenTime = token.substring(TOKEN_TIME_INDEX);
        try {
            byte[] tokenBytes = new BASE64Decoder().decodeBuffer(tokenTime);
            tokenTime = new String(tokenBytes, "utf-8");
            return Long.valueOf(tokenTime);
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        } catch (Exception e) {

        }
        return 0l;
    }

    public static Boolean verifyResetToken(User user, String token) {
        if (user == null || StringUtils.isEmpty(token)) {
            return false;
        }
        Long tokenTime = getResetPasswordTime(token);
        if (tokenTime == 0) {
            return false;
        }
        Long currentTime = new Date().getTime();
        if ((currentTime - tokenTime) > Global.getLongVal("reset.password.token.time")) {
            return false;
        }
        String userNameToken = token.substring(0, 10);
        if (!userNameToken.equalsIgnoreCase(MD5.md5(user.getLoginName()).substring(0, 10))) {
            return false;
        }

        return true;
    }

    public static String generateIdentityForResetPassword(User user) {
        String pre = RandomStringUtils.randomNumeric(5);
        String suffix = RandomStringUtils.randomNumeric(3);
        StringBuffer identity = new StringBuffer();
        identity.append(pre).append(user.getId()).append(suffix);
        return identity.toString();
    }

    public static Long getUserIdFromIdentity(String identity) {
        String idStr = identity.substring(5);
        idStr = idStr.substring(0, idStr.length() - 3);
        return Long.parseLong(idStr);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setLoginName("loginName");
        user.setId(123454L);
        String token = UserUtils.generateRestPasswordToken(user);
        System.out.println(token);
        System.out.println(UserUtils.getResetPasswordTime(token));
        System.out.println("验证token结果:"+ UserUtils.verifyResetToken(user,token));

        String identity = UserUtils.generateIdentityForResetPassword(user);
        System.out.println(identity);
        System.out.println(UserUtils.getUserIdFromIdentity(identity));

    }

}
