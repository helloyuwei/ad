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
            "shiro.properties",
            "mail.properties"});


    public static String getStringVal(String key) {
        if (properties == null) {
            return "";
        }
        return properties.getProperty(key);
    }

    public static Integer getIntVal(String key) {
        if (properties == null) {
            return 0;
        }
        return Integer.parseInt(properties.getProperty(key));
    }

    public static Long getLongVal(String key) {
        if (properties == null) {
            return 0L;
        }
        return Long.parseLong(properties.getProperty(key));
    }
}
