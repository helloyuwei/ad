package com.yuwei.adsense.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YuWei on 2016/9/22.
 */
public abstract class BaseServerController<E> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Model model;
    private E entity;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response,
                             @ModelAttribute("e") E entity, Model model) {
        this.entity = entity;
        this.request = request;
        this.response = response;
        this.model = model;
        model.addAttribute("e", entity);
        log.error("BaseAction:method called before:request=" + request + ",response=" + response
                + ",e=" + JSON.toJSONString(entity));
    }

    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return "";
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }
}
