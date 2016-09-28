package com.yuwei.adsense.freemarker.impl;

import com.google.common.collect.Maps;
import com.yuwei.adsense.core.UserUtils;
import com.yuwei.adsense.core.entity.Site;
import com.yuwei.adsense.core.entity.User;
import com.yuwei.adsense.freemarker.EmailTemplateService;
import com.yuwei.adsense.util.RequestUtils;
import com.yuwei.adsense.util.SpringContextUtils;

import java.util.Map;

/**
 * Created by YuWei on 2016/9/28.
 */
public class ResetPasswordEmailTemplateService extends EmailTemplateService<User> {

    public ResetPasswordEmailTemplateService() {
        super();
    }

    public String getString(User model) {
        Map<String, Object> param = Maps.newHashMap();
        param.put("token", UserUtils.generateRestPasswordToken(model));
        param.put("identity", UserUtils.generateIdentityForResetPassword(model));
        String host = RequestUtils.getRequest().getScheme() + "://" + RequestUtils.getRemoteHost() + ":" + RequestUtils.getRequest().getServerPort() + RequestUtils.getContextPath();
        param.put("host", host);
        Site currentSite = SpringContextUtils.getCurrentSite();
        param.put("site", currentSite);
        String content = parseTemplate(param, "resetPassword.ftl");
        return content;
    }

}
