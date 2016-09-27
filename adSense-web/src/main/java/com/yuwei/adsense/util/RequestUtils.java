package com.yuwei.adsense.util;

import com.yuwei.adsense.common.Global;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
    public static final String STATIC_RESOURCE_URL_KEY = "staticPath";
    public static final String CURRENT_SITE_KEY = "site";

    private static ThreadLocal<HttpServletRequest> servletRequestThreadLocal = new ThreadLocal<HttpServletRequest>();

    public static void setRequest(HttpServletRequest request) {
        servletRequestThreadLocal.set(request);
    }

    public static HttpServletRequest getRequest() {
        return servletRequestThreadLocal.get();
    }

    public static void setErrorMessage(String msg) {
        getRequest().setAttribute(ERROR_MESSAGE_PARAM, msg);
    }

    public static void setInfoMessage(String msg) {
        getRequest().setAttribute(INFO_MESSAGE_PARAM, msg);
    }

    public static String getRemoeIP() {

        String ip = getRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getRemoteAddr();
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

    public static String getRemoteHost() {
        if (getRequest() == null) {
            return "";
        }
        return getRequest().getRemoteAddr();
    }


    public static boolean isMobileLogin() {
        return WebUtils.isTrue(getRequest(), MOBILE_PARAM);
    }

    public static String getCaptcha() {
        return WebUtils.getCleanParam(getRequest(), CAPTCHA_PARAM);
    }

    public static String getAdminPath() {
        return Global.getStringVal(ADMIN_PATH_KEY);
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

    public static String getContextPath() {
        HttpServletRequest httpServletRequest = getRequest();
        return httpServletRequest.getContextPath();
    }

    public static String getStaticUrl() {
        return Global.getStringVal(RequestUtils.STATIC_RESOURCE_URL_KEY);
    }

    public static boolean isStaticFile(String uri) {
        if (StringUtils.isEmpty(uri)) {
            return false;
        }
        if (uri.startsWith(RequestUtils.getStaticUrl())) {
            return true;
        }
        return false;
    }

    public static boolean isRememberMe() {
        String rememberMe = WebUtils.getCleanParam(RequestUtils.getRequest(), "rememberMe");
        if (StringUtils.isNotEmpty(rememberMe)
                && ("true".equalsIgnoreCase(rememberMe) || !"0".equalsIgnoreCase(rememberMe) || "no".equalsIgnoreCase(rememberMe))) {
            return true;
        }
        return false;
    }
}
