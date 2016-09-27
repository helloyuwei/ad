package com.yuwei.adsense.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by YuWei on 2016/9/23.
 */
@Service("idGen")
public class IdGens implements SessionIdGenerator {
    public Serializable generateId(Session session) {
        return RandomStringUtils.randomAlphabetic(Integer.parseInt(Global.getStringVal("session.id.length")));
    }
}
