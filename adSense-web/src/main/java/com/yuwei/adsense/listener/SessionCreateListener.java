package com.yuwei.adsense.listener;

import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.services.SiteService;
import com.yuwei.adsense.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by YuWei on 2016/9/27.
 */
public class SessionCreateListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sessionCreated(HttpSessionEvent se) {
        SiteService siteService = SpringContextUtils.getApplicationContext().getBean(SiteService.class);
        if(siteService == null){
            logger.warn("Initialized SiteService bean failed.");
            return;
        }
        Site site = SpringContextUtils.getCurrentSite();
        if(site == null){
            logger.warn("Load current site failed");
            return;
        }
        site.setSiteViewCount(site.getSiteViewCount()+1);
        logger.info("Site "+site.getSiteName() +" has been "+ site.getSiteViewCount() + " view so far.");
        siteService.saveOrUpdate(site);
        return;
    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
