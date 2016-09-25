package com.yuwei.adsense.core.entity;

/**
 *  <br />
 * @createTime 2016-9-25 21:39:29
 * @author template
 */public class Permission extends BaseEntity {

    /**
     * 
     */
    private String permission;

    public void setPermission (String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return this.permission;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Permission [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", permission = ");
        sb.append(permission);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}