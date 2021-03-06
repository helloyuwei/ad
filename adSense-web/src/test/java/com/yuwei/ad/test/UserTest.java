package com.yuwei.ad.test;

import com.alibaba.fastjson.JSON;
import com.yuwei.adsense.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YuWei on 2016/9/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext*.xml")
public class UserTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void listRolesTest(){
        System.out.println(JSON.toJSONString(userService.listRoles(1L)));
    }
}
