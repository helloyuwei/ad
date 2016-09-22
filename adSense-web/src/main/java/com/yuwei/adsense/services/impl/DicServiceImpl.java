package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Dic;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.DicDao;
import com.yuwei.adsense.services.DicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:16
 */
@Service
public class DicServiceImpl extends BaseServiceImpl<Dic, Long> implements DicService {
    private final static Logger LOG = LoggerFactory
            .getLogger(DicServiceImpl.class);

    @Autowired
    private DicDao dicDao;

    public BaseDao<Dic, Long> getDao() {
        return dicDao;
    }
}
