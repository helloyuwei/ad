package com.yuwei.adsense.services;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YuWei on 2016/9/22.
 */
public interface BaseService<T, KEY extends Serializable> {
    int insert(T var1);

    int batchInsert(List<T> var1);

    int del(KEY var1);

    int update(T var1);

    int batchUpdate(List<T> var1);

    int saveOrUpdate(T var1);

    T get(KEY var1);

    List<T> list(T var1);
}
