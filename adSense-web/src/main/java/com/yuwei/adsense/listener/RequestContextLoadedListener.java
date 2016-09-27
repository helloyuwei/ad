package com.yuwei.adsense.listener;

import com.yuwei.adsense.util.RequestUtils;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by YuWei on 2016/9/27.
 */
public class RequestContextLoadedListener extends RequestContextListener {
    public void requestInitialized(ServletRequestEvent requestEvent) {
        super.requestInitialized(requestEvent);
        RequestUtils.setRequest((HttpServletRequest) requestEvent.getServletRequest());
    }
}
