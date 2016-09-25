package com.yuwei.adsense.web;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YuWei on 2016/9/23.
 */
public class Servlets {
    private static HttpServletRequest request;

    public static HttpServletRequest getRequest() {
        return request;
    }

    public static boolean isStaticFile(String uri) {
        return false;
    }
}
