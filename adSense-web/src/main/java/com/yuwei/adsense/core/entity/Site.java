package com.yuwei.adsense.core.entity;

/**
 * <br />
 *
 * @author template
 * @createTime 2016-9-22 23:05:16
 */
public class Site extends BaseEntity {

    /**
     *
     */
    private String siteName;

    /**
     *
     */
    private Integer siteViewCount;

    /**
     * 备案信息
     */
    private String siteIcp;

    /**
     *
     */
    private String copyright;

    /**
     *
     */
    private String siteUrl;

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteViewCount(Integer siteViewCount) {
        this.siteViewCount = siteViewCount;
    }

    public Integer getSiteViewCount() {
        return this.siteViewCount;
    }

    public void setSiteIcp(String siteIcp) {
        this.siteIcp = siteIcp;
    }

    public String getSiteIcp() {
        return this.siteIcp;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteUrl() {
        return this.siteUrl;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Site [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", siteName = ");
        sb.append(siteName);
        sb.append(", siteViewCount = ");
        sb.append(siteViewCount);
        sb.append(", siteIcp = ");
        sb.append(siteIcp);
        sb.append(", copyright = ");
        sb.append(copyright);
        sb.append(", siteUrl = ");
        sb.append(siteUrl);
        sb.append("]");
        return sb.toString();
    }
}