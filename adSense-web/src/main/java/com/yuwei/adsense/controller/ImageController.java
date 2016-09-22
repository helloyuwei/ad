
package com.yuwei.adsense.controller;

import com.yuwei.adsense.core.entity.Image;
import com.yuwei.adsense.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 图片 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:18
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController extends BaseServerController<Image> {

    @Autowired
    private ImageService imageService;

}
