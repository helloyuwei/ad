
package com.yuwei.adsense.controller;


import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-22 23:05:16
 */
@Controller
@RequestMapping(value = "/site")
public class SiteController extends BaseWebController<Site> {

    @Autowired
    private SiteService siteService;
}
