package com.yuwei.adsense.services.impl;

import com.yuwei.adsense.core.entity.Menu;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.dao.MenuDao;
import com.yuwei.adsense.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 菜单名 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:20
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, Long> implements MenuService {
    private final static Logger LOG = LoggerFactory
            .getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDao menuDao;

    public BaseDao<Menu, Long> getDao() {
        return menuDao;
    }
}
