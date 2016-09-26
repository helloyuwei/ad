package com.yuwei.adsense.util;

import com.yuwei.adsense.common.Global;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by YuWei on 2016/9/23.
 */
public class RequestUtils {

    public static final String CAPTCHA_PARAM = "verifyCode";
    public static final String MOBILE_PARAM = "mobileLogin";
    public static final String ERROR_MESSAGE_PARAM = "error_msg";
    public static final String INFO_MESSAGE_PARAM = "info_msg";
    public static final String ADMIN_PATH_KEY = "adminPath";
    public static final String CONTEXT_PATH_KEY = "ctx";

    public static String getRemoeIP(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }

    public static String getRemoteHost(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        return request.getRemoteAddr();
    }


    public static boolean isMobileLogin(ServletRequest request) {
        return WebUtils.isTrue(request, MOBILE_PARAM);
    }

    public static String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, CAPTCHA_PARAM);
    }

    public static String getAdminPath() {
        return Global.getConfig(ADMIN_PATH_KEY);
    }

    public static String getAdminUrl(String url) {
        if (url == null) {
            return url;
        }
        if (url.startsWith("/")) {
            return getAdminPath() + url;
        }
        return getAdminPath() + "/" + url;
    }

    public static String getRedirectAdminUrl(String url) {
        if (url == null) {
            return url;
        }
        if (url.startsWith("/")) {
            return getAdminPath() + url;
        }
        return "redirect:" + getAdminPath() + "/" + url;
    }

    public static String getForwardAdminUrl(String url) {
        return InternalResourceViewResolver.FORWARD_URL_PREFIX + getAdminUrl(url);
    }

    public static void addPropertyToSession(HttpServletRequest request, String key, Object value) {

        request.getSession(true).setAttribute(key, value);
    }

    public static String getContextPath(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        return httpServletRequest.getContextPath();
    }
}
