package com.yuwei.adsense.core.entity;

/**
 * 字典 <br />
 *
 * @author template
 * @createTime 2016-9-22 15:56:16
 */
public class Dic extends BaseEntity {

    /**
     *
     */
    private String dicName;

    /**
     *
     */
    private String dicValue;

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicName() {
        return this.dicName;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getDicValue() {
        return this.dicValue;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Dic [");
        sb.append("id = ");
        sb.append(id);
        sb.append(", dicName = ");
        sb.append(dicName);
        sb.append(", dicValue = ");
        sb.append(dicValue);
        sb.append(", isDelete = ");
        sb.append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}