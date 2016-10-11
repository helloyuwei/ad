package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.ad.template.parser.AdsTemplateParser;
import com.yuwei.adsense.controller.BaseWebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by YuWei on 2016/10/11.
 */
@Controller
@RequestMapping("/admin/ads/upload")
public class AdsUploadController extends BaseWebController {

    @Resource(name = "jdAdsTemplateParser")
    private AdsTemplateParser jdAdsTempaltePaser;
    
    @Resource(name = "taobaoAdsTemplateParser")
    private AdsTemplateParser taobaoTemplateParser;
}
