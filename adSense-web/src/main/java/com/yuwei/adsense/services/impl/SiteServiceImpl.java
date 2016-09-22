package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.SiteDao;
import com.yuwei.adsense.services.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-22 23:05:16
 */
@Service
public class SiteServiceImpl extends BaseServiceImpl<Site, Long> implements SiteService {
    private final static Logger LOG = LoggerFactory
            .getLogger(SiteServiceImpl.class);

    @Autowired
    private SiteDao siteDao;

    public BaseDao<Site, Long> getDao() {
        return siteDao;
    }
}
