package com.yuwei.adsense.common;

import org.apache.log4j.Logger;

/**
 * Created by YuWei on 2016/9/23.
 */
public class Global {
    private static final Logger logger = Logger.getLogger(Global.class);
    public static final String FALSE = "false";
    public static final String NO = "No";

    private static PropertiesLoader properties = new PropertiesLoader(new String[]{
            "/site.properties",
            "/dataSource.properties",
            "shiro.properties"});


    public static String getConfig(String key) {
        if (properties == null) {
            return "";
        }
        return properties.getProperty(key);
    }
}
