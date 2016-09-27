package com.yuwei.adsense.jms;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by YuWei on 2016/9/27.
 */
public class ActiveMqMessageConverter implements MessageConverter {
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        return null;
    }

    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return null;
    }
}
