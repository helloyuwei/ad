package com.yuwei.adsense.filter;

import com.yuwei.adsense.util.RequestUtils;

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
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
