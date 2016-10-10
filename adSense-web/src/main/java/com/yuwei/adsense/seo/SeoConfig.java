package com.yuwei.adsense.seo;

import java.util.HashMap;

/**
 * Created by YuWei on 2016/10/10.
 */
public class SeoConfig extends HashMap<String, String> {
    private String url;

    public SeoConfig(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
