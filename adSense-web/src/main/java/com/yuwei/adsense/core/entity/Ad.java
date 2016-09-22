package com.yuwei.adsense.core.entity;

/**
 * 广告 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:14
 */
public class Ad extends BaseEntity {

    /**
     * 来源 1->百度，2->京东，3->腾讯; 4->阿里；5->google;6->网易
     */
    private Integer from;

    /**
     * 类型：0->自有;1->CPM弹窗形式广告;2->CPC点击形式广告;3->CPA注册形式广告;4->CPS销售提成形式广告;5->CPV富媒体形式广告
     */
    private Integer type;

    /**
     * 广告位宽
     */
    private Integer width;

    /**
     * 广告位高
     */
    private Integer height;

    /**
     * 是否生效
     */
    private Integer isActive;

    /**
     * 开始生效时间
     */
    private Integer startTime;

    /**
     * 结束时间
     */
    private Integer endTime;

    /**
     * 点击跳转次数
     */
    private Integer hitCount;

    /**
     * 浏览次数
     */
    private Integer viewCount;

    /**
     *
     */
    private Integer contentType;


    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getFrom() {
        return this.from;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public Integer getHitCount() {
        return this.hitCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getViewCount() {
        return this.viewCount;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getContentType() {
        return this.contentType;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Ad [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", from = ");
        sb.append(from);
        sb.append(", type = ");
        sb.append(type);
        sb.append(", width = ");
        sb.append(width);
        sb.append(", hight = ");
        sb.append(height);
        sb.append(", isActive = ");
        sb.append(isActive);
        sb.append(", startTime = ");
        sb.append(startTime);
        sb.append(", endTime = ");
        sb.append(endTime);
        sb.append(", hitCount = ");
        sb.append(hitCount);
        sb.append(", viewCount = ");
        sb.append(viewCount);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append(", contentType = ");
        sb.append(contentType);
        sb.append("]");
        return sb.toString();
    }
}