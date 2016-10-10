package com.yuwei.adsense.util;

import com.google.common.collect.Lists;
import com.yuwei.adsense.core.entity.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YuWei on 2016/9/27.
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

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

    public void setApplicationContext(ApplicationContext applicationContext) {
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

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return SpringContextUtils.applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) SpringContextUtils.applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return (T) SpringContextUtils.applicationContext.getBeansOfType(clazz);
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext() {
        SpringContextUtils.applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (SpringContextUtils.applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }
}
