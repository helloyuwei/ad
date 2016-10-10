package com.yuwei.adsense.filter;

import com.yuwei.adsense.util.RequestUtils;
import com.yuwei.adsense.util.SpringContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by YuWei on 2016/9/23.
 */
public class PopulateConfigFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.setAttribute(RequestUtils.ADMIN_PATH_KEY, RequestUtils.getAdminPath());
        RequestUtils.addPropertyToSession(httpServletRequest, RequestUtils.ADMIN_PATH_KEY, RequestUtils.getAdminPath());
        httpServletRequest.setAttribute(RequestUtils.CONTEXT_PATH_KEY, RequestUtils.getContextPath());
        httpServletRequest.setAttribute(RequestUtils.STATIC_RESOURCE_URL_KEY, RequestUtils.getStaticUrl());
        httpServletRequest.setAttribute(RequestUtils.CURRENT_SITE_KEY, SpringContextUtils.getCurrentSite());
        httpServletRequest.setAttribute(RequestUtils.ACTION_SUFFIX, RequestUtils.getActionSuffix());
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
