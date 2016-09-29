
package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.controller.BaseWebController;
import com.yuwei.adsense.core.entity.Menu;
import com.yuwei.adsense.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单名 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:20
 */
@Controller
@RequestMapping(value = "/admin/menu")
public class AdminMenuController extends BaseWebController<Menu> {

    @Autowired
    private MenuService menuService;

/*
    @RequestMapping("/list")
    public String resetPassword(HttpServletRequest request) {

        return
    }*/
}
