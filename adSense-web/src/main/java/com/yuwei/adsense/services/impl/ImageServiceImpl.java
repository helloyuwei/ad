package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Image;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.ImageDao;
import com.yuwei.adsense.services.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片 <br />
 * @createTime 2016-9-22 15:56:18
 * @author template
 */
@Service
public class ImageServiceImpl extends BaseServiceImpl<Image, Long> implements ImageService {
    private final static Logger LOG = LoggerFactory
            .getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageDao imageDao;

    public BaseDao<Image, Long> getDao() {
        return imageDao;
    }
}
