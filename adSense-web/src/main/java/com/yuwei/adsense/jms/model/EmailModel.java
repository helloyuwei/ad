package com.yuwei.adsense.jms.model;

import java.io.Serializable;

/**
 * Created by YuWei on 2016/9/28.
 */
public class EmailModel implements Serializable {
    private String to;
    private String title;
    private String content;

    public EmailModel(String to, String title, String content) {
        this.to = to;
        this.title = title;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
