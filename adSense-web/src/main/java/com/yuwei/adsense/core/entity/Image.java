package com.yuwei.adsense.core.entity;
/**
 * 图片 <br />
 * @createTime 2016-9-22 15:56:18
 * @author template
 */public class Image extends BaseEntity {

    /**
     * 
     */
    private String imagePath;

    public void setImagePath (String imagePath){
        this.imagePath = imagePath;
    }
    public String getImagePath(){
        return this.imagePath;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Image [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", imagePath = ");
        sb.append(imagePath);
        sb.append("]");
        return sb.toString();
    }
}