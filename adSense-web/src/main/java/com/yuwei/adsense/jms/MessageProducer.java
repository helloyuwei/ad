package com.yuwei.adsense.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * Created by YuWei on 2016/9/27.
 */
@Service("messageProducer")
public class MessageProducer {
    private static final Logger logger = Logger.getLogger(MessageProducer.class);
    @Resource(name = "messageQueue")
    private Queue messageQueue;
    @Resource
    private JmsTemplate jmsTemplate;

    public void send(Object model) {
        logger.debug("product the message");

        this.jmsTemplate.convertAndSend(messageQueue, model);
    }
}
