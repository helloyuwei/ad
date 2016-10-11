package com.yuwei.adsense.ad.template.entity;

/**
 * Created by YuWei on 2016/10/11.
 */
public class RecommendObject {
    private String goodsId;
    private String name;
    private String imgUrl;
    private Double price;
    private Long startTime;
    private Long endTime;
    private String shortUrl;
    private String longUrl;

    private CouponObject coupon;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public CouponObject getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponObject coupon) {
        this.coupon = coupon;
    }
}
