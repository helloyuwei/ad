package com.yuwei.adsense.ad.template.parser.impl;

import com.yuwei.adsense.ad.template.entity.CouponObject;
import com.yuwei.adsense.ad.template.entity.RecommendObject;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by YuWei on 2016/10/11.
 */
@Service("taobaoRecommendParser")
public class TaoBaoRecommendParserImpl extends RecommendParserAdapter<RecommendObject> {

    protected RecommendObject doRow(Row row) {
        RecommendObject ro = new RecommendObject();
        ro.setGoodsId(row.getCell(0).getStringCellValue());
        ro.setName(row.getCell(1).getStringCellValue());
        ro.setImgUrl(row.getCell(2).getStringCellValue());
        ro.setShortUrl(row.getCell(15).getStringCellValue());
        ro.setLongUrl(row.getCell(16).getStringCellValue());
        ro.setPrice(Double.valueOf(row.getCell(5).getStringCellValue()));
        ro.setStartTime(parsTime(row.getCell(12).getStringCellValue()));
        ro.setEndTime(parsTime(row.getCell(13).getStringCellValue()));
        CouponObject coupon = new CouponObject();
        coupon.setUrl(row.getCell(23).getStringCellValue());
        coupon.setGoodsId(row.getCell(0).getStringCellValue());
        coupon.setStartTime(parsTime(row.getCell(21).getStringCellValue()));
        coupon.setEndTime(parsTime(row.getCell(22).getStringCellValue()));
        coupon.setDesc(row.getCell(20).getStringCellValue());
        ro.setCoupon(coupon);
        return ro;
    }

    public static void main(String[] args) {
        File file = new File("D://test.xls");
        List<RecommendObject> recommendObjectList = new TaoBaoRecommendParserImpl().parse(file);
        System.out.println(recommendObjectList.size());
    }
}
