package com.yuwei.adsense.core.entity;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-25 21:39:30
 */
public class RolePermossion extends BaseEntity {

    /**
     *
     */
    private Long roleId;

    /**
     *
     */
    private Long permId;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    public Long getPermId() {
        return this.permId;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("RolePermossion [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", roleId = ");
        sb.append(roleId);
        sb.append(", permId = ");
        sb.append(permId);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}