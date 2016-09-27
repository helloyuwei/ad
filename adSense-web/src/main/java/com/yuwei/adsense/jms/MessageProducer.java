package com.yuwei.adsense.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by YuWei on 2016/9/27.
 */
public class MessageProducer {
    private static final Logger logger = Logger.getLogger(MessageProducer.class);
    @Resource(name = "messageQueue")
    private Destination messageQueue;
    @Resource
    private JmsTemplate jmsTemplate;

    public void send(Object model) {
        logger.debug("product the message");

        this.jmsTemplate.convertAndSend(messageQueue, model);
    }
}
