
package com.yuwei.adsense.controller.admin;

import com.yuwei.adsense.controller.BaseWebController;
import com.yuwei.adsense.core.entity.Dic;
import com.yuwei.adsense.services.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 字典 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:16
 */
@Controller
@RequestMapping(value = "/dic")
public class DicController extends BaseWebController<Dic> {

    @Autowired
    private DicService dicService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add() {
        dicService.insert(getEntity());
        return "/";
    }
}
