package com.yuwei.adsense.seo.impl;

import com.yuwei.adsense.seo.SeoConfig;
import com.yuwei.adsense.seo.SeoPusher;
import com.yuwei.adsense.util.HttpUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YuWei on 2016/10/10.
 */
@Component
public class BaiDuSeoPusher implements SeoPusher {
    private static final Logger logger = LoggerFactory.getLogger(BaiDuSeoPusher.class);

    @Autowired
    private HttpUtil httpUtil;


    public SeoConfig getConfig() {
        SeoConfig seoConfig = new SeoConfig(" http://data.zz.baidu.com/urls");
        seoConfig.put("site", "www.happy-ad.cn");
        seoConfig.put("token", "kHjjjPSD1Vi4wmJu");
        // seoConfig.put("type","original");
        return seoConfig;
    }

    public void pushUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return;
        }
        httpUtil.post(getConfig().getUrl(), null);
        logger.info("提交url到百度成功!");
    }

    public void pushUrls(List<String> urls) {
        if (CollectionUtils.isEmpty(urls)) {
            return;
        }
        for (String url : urls) {
            pushUrl(url);
        }
    }
}
