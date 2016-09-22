package com.yuwei.adsense.services.impl;

/**
 * Created by YuWei on 2016/9/22.
 */

import com.yuwei.adsense.core.entity.BaseEntity;
import com.yuwei.adsense.dao.BaseDao;
import com.yuwei.adsense.services.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T, KEY extends Serializable> implements BaseService<T, KEY> {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    public BaseServiceImpl() {
    }

    public abstract BaseDao<T, KEY> getDao();

    public int insert(T t) {
        return this.getDao().insert(t);
    }

    public int batchInsert(List<T> list) {
        return this.getDao().batchInsert(list);
    }

    public int del(KEY key) {
        return this.getDao().del(key);
    }

    public int update(T condtion) {
        return this.getDao().update(condtion);
    }

    public int batchUpdate(List<T> list) {
        return this.getDao().batchUpdate(list);
    }

    public int saveOrUpdate(T t) {
        Long id = Long.valueOf(0L);
        if (t instanceof BaseEntity) {
            id = ((BaseEntity) t).getId();
        } else {
            try {
                Class e = t.getClass();
                id = (Long) e.getMethod("getId", new Class[0]).invoke(t, new Object[0]);
            } catch (Exception var4) {
                LOGGER.warn("获取对象主键值失败!");
            }
        }

        return id != null && id.longValue() > 0L ? this.update(t) : this.insert(t);
    }

    public T get(KEY key) {
        return this.getDao().get(key);
    }

    public List<T> list(KEY key) {
        return this.getDao().list(key);
    }

    public List<T> list(T condtion) {
        return this.getDao().list(condtion);
    }
}
