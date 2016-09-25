package com.yuwei.adsense.core.entity;


import java.util.List;

/**
 * Created by YuWei on 2016/9/23.
 */
public class User extends BaseEntity {

    private List<Role> roles;

    /**
     *
     */
    private String loginName;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String nickName;

    /**
     *
     */
    private Integer isActive;

    public void setLoginName (String loginName){
        this.loginName = loginName;
    }
    public String getLoginName(){
        return this.loginName;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setNickName (String nickName){
        this.nickName = nickName;
    }
    public String getNickName(){
        return this.nickName;
    }
    public void setIsActive (Integer isActive){
        this.isActive = isActive;
    }
    public Integer getIsActive(){
        return this.isActive;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("User [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", loginName = ");
        sb.append(loginName);
        sb.append(", password = ");
        sb.append(password);
        sb.append(", nickName = ");
        sb.append(nickName);
        sb.append(", isActive = ");
        sb.append(isActive);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append("]");
        return sb.toString();
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
