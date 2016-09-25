package com.yuwei.adsense.core.entity;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-25 21:39:31
 */
public class UserRole extends BaseEntity {

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private Long roleId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("UserRole [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", userId = ");
        sb.append(userId);
        sb.append(", roleId = ");
        sb.append(roleId);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}