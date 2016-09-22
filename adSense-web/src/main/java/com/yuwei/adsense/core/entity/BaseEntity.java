package com.yuwei.adsense.core.entity;

/**
 * Created by YuWei on 2016/9/22.
 */
public class BaseEntity {
    protected Long id;

    protected Integer isDelete = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
