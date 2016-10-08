package com.yuwei.ad.test;

import com.alibaba.fastjson.JSON;
import com.yuwei.adsense.core.entity.Menu;
import com.yuwei.adsense.services.MenuService;
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
public class MenuTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private MenuService menuService;

    @Test
    public void listTest() {
        Menu param = new Menu();
        param.setSiteId(1L);
        param.setParentId(0L);
        param.setShowing(1);
        param.setIsDelete(0);
      System.out.println(JSON.toJSONString( menuService.list(param)));
    }

    //@Test
    public void addTest(){
        Menu param = new Menu();
        param.setParentId(5L);
        param.setShowing(1);
        param.setIsDelete(0);
        param.setSiteId(1L);
        param.setDisplayName("test11");
        param.setOrder(0);
        param.setKeyName("test11");
        param.setUrl("/");
        menuService.saveOrUpdate(param);
    }
    //@Test
    public void updateTest(){
        Menu param = new Menu();
        param.setId(6L);
        param.setDisplayName("test111");
        param.setKeyName("test111");
        menuService.saveOrUpdate(param);
    }
}
