package com.yuwei.adsense.core.entity;

import java.util.List;

/**
 * 菜单名 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:20
 */
public class Menu extends BaseEntity {

    private List<Menu> child;

    private Long siteId;

    private Integer order;

    /**
     *
     */
    private String displayName;

    /**
     *
     */
    private String keyName;

    /**
     * 父节点ID
     */
    private Long parentId;

    /**
     * 是否显示
     */
    private Integer showing;

    /**
     * 图标css class
     */
    private String imageClass;

    /**
     * 图片ID
     */
    private Long imageId;

    /**
     * url 地址
     */
    private String url;

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setShowing(Integer showing) {
        this.showing = showing;
    }

    public Integer getShowing() {
        return this.showing;
    }

    public void setImageClass(String imageClass) {
        this.imageClass = imageClass;
    }

    public String getImageClass() {
        return this.imageClass;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getImageId() {
        return this.imageId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Menu [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", displayName = ");
        sb.append(displayName);
        sb.append(", keyName = ");
        sb.append(keyName);
        sb.append(", parentId = ");
        sb.append(parentId);
        sb.append(", showing = ");
        sb.append(showing);
        sb.append(", imageClass = ");
        sb.append(imageClass);
        sb.append(", imageId = ");
        sb.append(imageId);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append(", url = ");
        sb.append(url);
        sb.append("]");
        return sb.toString();
    }
}