package com.yuwei.adsense.jms.handler.impl;

import com.yuwei.adsense.jms.handler.IJmsHandler;
import com.yuwei.adsense.jms.model.EmailModel;
import com.yuwei.adsense.util.MailUtil;

/**
 * Created by YuWei on 2016/9/28.
 */
public class SendEmailHandler implements IJmsHandler {

    public void handMessage(Object paramObject) {
        if(paramObject== null || !(paramObject instanceof EmailModel)){
            return;
        }
        EmailModel emailModel = (EmailModel) paramObject;
        MailUtil.getInstance().startSend(emailModel.getTo(),emailModel.getTitle(), emailModel.getContent());
    }
}
