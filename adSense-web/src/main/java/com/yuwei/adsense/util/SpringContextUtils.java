package com.yuwei.adsense.util;

import com.google.common.collect.Lists;
import com.yuwei.adsense.core.entity.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by YuWei on 2016/9/27.
 */
public class SpringContextUtils {

    private static final Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);

    private static List<Site> sites = Lists.newArrayList();

    private static ApplicationContext webApplicationContext;

    private static ApplicationContext applicationContext;

    public static ApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }

    public static void setWebApplicationContext(ApplicationContext webApplicationContext) {
        SpringContextUtils.webApplicationContext = webApplicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static void addAllSites(List<Site> sites) {
        SpringContextUtils.sites.addAll(sites);
    }

    public static Site getCurrentSite() {
        if (sites == null) {
            return null;
        }
        String servletPath = RequestUtils.getRequest().getServletPath();
        for (Site site : SpringContextUtils.sites) {
            if (servletPath.startsWith(site.getSiteUrl())) {
                return site;
            }
        }
        logger.warn("Can not find site for current url:", servletPath);
        return null;
    }
}
