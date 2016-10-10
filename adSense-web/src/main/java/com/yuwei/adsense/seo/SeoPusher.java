package com.yuwei.adsense.seo;

import java.util.List;

/**
 * Created by YuWei on 2016/10/10.
 */
public interface SeoPusher {
    SeoConfig getConfig();

    void pushUrl(String url);

    void pushUrls(List<String> urls);
}
