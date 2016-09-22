
package com.yuwei.adsense.controller;

import com.yuwei.adsense.core.entity.Menu;
import com.yuwei.adsense.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单名 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:20
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseServerController<Menu> {

    @Autowired
    private MenuService menuService;

}
