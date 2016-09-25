package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.util.RequestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YuWei on 2016/9/25.
 */
@Controller
@RequestMapping("/admin")
public class MainPanelController {
    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/main")
    public String main(HttpServletRequest request) {

        return RequestUtils.getAdminUrl("/main");
    }
}
