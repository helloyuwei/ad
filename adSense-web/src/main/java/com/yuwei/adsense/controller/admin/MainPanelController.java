package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.core.entity.Menu;
import com.yuwei.adsense.services.MenuService;
import com.yuwei.adsense.util.RequestUtils;
import com.yuwei.adsense.util.SpringContextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by YuWei on 2016/9/25.
 */
@Controller
@RequestMapping("/admin")
public class MainPanelController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/main")
    public ModelAndView main(HttpServletRequest request) {
        Menu param = new Menu();
        param.setSiteId(SpringContextUtils.getCurrentSite().getId());
        param.setParentId(0L);
        param.setShowing(1);
        param.setIsDelete(0);
        List<Menu> menus = menuService.list(param);
        ModelAndView modelAndView = new ModelAndView(RequestUtils.getAdminUrl("/main"));
        modelAndView.addObject("menus", menus);
        return modelAndView;
    }

}
