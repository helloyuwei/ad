package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Ad;
import com.yuwei.adsense.dao.AdDao;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.services.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 广告 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:14
 */
@Service
public class AdServiceImpl extends BaseServiceImpl<Ad, Long> implements AdService {
    private final static Logger LOG = LoggerFactory
            .getLogger(AdServiceImpl.class);

    @Autowired
    private AdDao adDao;

    public BaseDao<Ad, Long> getDao() {
        return adDao;
    }
}
