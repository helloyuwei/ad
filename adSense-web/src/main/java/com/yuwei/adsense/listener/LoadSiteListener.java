package com.yuwei.adsense.listener;

import com.yuwei.adsense.common.SiteContext;
import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.services.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * Created by YuWei on 2016/9/26.
 */
public class LoadSiteListener implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SiteService siteService;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            logger.info("加载站点信息.....");
            List<Site> sites = siteService.loadAllSites();
            SiteContext.addAllSites(sites);
            logger.info("站点信息加载完成....");
        }
    }
}
