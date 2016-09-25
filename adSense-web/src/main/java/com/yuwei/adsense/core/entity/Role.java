package com.yuwei.adsense.core.entity;

import java.util.List;

/**
 * Created by YuWei on 2016/9/23.
 */
public class Role extends BaseEntity {
    private String name;

    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
