package com.yuwei.adsense.rec.template.parser.impl;

import com.yuwei.adsense.rec.template.entity.RecommendObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by YuWei on 2016/10/11.
 */
@Component("jdRecommendParser")
public class JDRecommendParserImpl extends RecommendParserAdapter<RecommendObject> {

    protected RecommendObject doRow(Row row) {
        RecommendObject ro = new RecommendObject();
        ro.setName(row.getCell(0).getStringCellValue());
        ro.setShortUrl(row.getCell(6).getStringCellValue());
        ro.setLongUrl(row.getCell(6).getStringCellValue());
        ro.setPrice(Double.valueOf(row.getCell(2).getStringCellValue()));
        String time = row.getCell(7).getStringCellValue();
        if (!StringUtils.isEmpty(time)) {
            String[] values = time.split("至");
            ro.setStartTime(getTimeFromString(values[0].trim()));
            ro.setEndTime(getTimeFromString(values[1].trim()));
        }
        return ro;
    }

    public static void main(String[] args) {
        File file = new File("D://test1.xlsx");
        List<RecommendObject> recommendObjectList = new JDRecommendParserImpl().parse(file);
        System.out.println(recommendObjectList.size());
    }
}
