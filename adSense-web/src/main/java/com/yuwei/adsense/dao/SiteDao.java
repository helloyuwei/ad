
package com.yuwei.adsense.dao;


import com.yuwei.adsense.core.entity.Site;

import java.util.List;

/**
 *  <br />
 * @createTime 2016-9-22 23:05:16
 * @author template
 */
public interface SiteDao extends BaseDao<Site,Long> {

    List<Site> loadAllSites();
}
