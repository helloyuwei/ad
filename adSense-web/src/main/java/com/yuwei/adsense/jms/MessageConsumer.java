package com.yuwei.adsense.jms;

import com.yuwei.adsense.jms.handler.IJmsHandler;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YuWei on 2016/9/27.
 */
public class MessageConsumer {
    private Map<String, IJmsHandler> handlers = new HashMap<String, IJmsHandler>();
    protected Logger logger = Logger.getLogger(MessageConsumer.class);

    public void setHandlers(Map<String, IJmsHandler> handlers) {
        this.handlers = handlers;
    }

    public void sendMessage(Object model) throws Exception {
        if (handlers != null && model != null) {
            IJmsHandler jmsHandler = (IJmsHandler) this.handlers.get(model.getClass().getName());
            if (jmsHandler != null) {
                jmsHandler.handMessage(model);
            } else {
                this.logger.info(model.toString());
            }
        } else {
            throw new Exception("Object:[" + model + "] is not  entity Object ");
        }
    }
}
