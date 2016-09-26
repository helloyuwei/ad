package com.yuwei.adsense.common;

import com.google.common.collect.Lists;
import com.yuwei.adsense.core.entity.Site;

import java.util.List;

/**
 * Created by YuWei on 2016/9/26.
 */
public class SiteContext {
    private static List<Site> sites = Lists.newArrayList();

    public static void addAllSites(List<Site> sites) {
        sites.addAll(sites);
    }
}
