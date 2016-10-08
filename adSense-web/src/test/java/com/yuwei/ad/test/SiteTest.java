package com.yuwei.ad.test;

import com.alibaba.fastjson.JSON;
import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.services.SiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YuWei on 2016/9/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext*.xml")
public class SiteTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private SiteService siteService;

    @Test
    public void listTest() {
        System.out.println(JSON.toJSONString(siteService.loadAllSites()));
    }

    @Test
    public void addTest() {
        Site site = new Site();
        site.setSiteViewCount(0);
        site.setIsDelete(0);
        site.setSiteIcp("");
        site.setSiteName("test");
        site.setSiteUrl("/test");
        site.setCopyright("醉意网 &copy; 2016");
        siteService.saveOrUpdate(site);

    }

    @Test
    public void updateTest() {
        Site site = new Site();
        site.setId(3L);
        site.setIsDelete(0);
        siteService.saveOrUpdate(site);
    }
}
