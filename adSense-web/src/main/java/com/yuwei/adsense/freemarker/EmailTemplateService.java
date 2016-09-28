package com.yuwei.adsense.freemarker;

import com.yuwei.adsense.util.SpringContextUtils;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Map;

/**
 * Created by YuWei on 2016/9/28.
 */
public abstract class EmailTemplateService<T> {
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public EmailTemplateService(){
        freeMarkerConfigurer = (FreeMarkerConfigurer) SpringContextUtils.getApplicationContext().getBean("freeMarkerConfigurer");
    }
    /**
     * 生成html模板字符串
     *
     * @param root 存储动态数据的map
     * @return
     */
    protected String parseTemplate(Map<String, Object> root, String templateName) {
        String htmlText = "";
        try {
            //通过指定模板名获取FreeMarker模板实例
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlText;
    }

    public abstract String getString(T model);

    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        return freeMarkerConfigurer;
    }

    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }
}