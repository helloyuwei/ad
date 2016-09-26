package com.yuwei.adsense.services;


import com.yuwei.adsense.core.entity.Site;

import java.util.List;

/**
 *  <br />
 * @createTime 2016-9-22 23:05:16
 * @author template
 */
public interface SiteService extends BaseService<Site, Long> {

    List<Site> loadAllSites();
}
