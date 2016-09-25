
package com.yuwei.adsense.controller;


import com.yuwei.adsense.core.entity.Ad;
import com.yuwei.adsense.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 广告 <br />
 * @createTime 2016-9-22 15:56:14
 * @author template
 */
@Controller
@RequestMapping(value = "/ad")
public class AdController extends BaseWebController<Ad> {

    @Autowired
    private AdService adService;



}
