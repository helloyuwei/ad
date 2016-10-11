package com.yuwei.adsense.rec.template.parser.impl;

import com.google.common.collect.Lists;
import com.yuwei.adsense.rec.template.entity.RecommendObject;
import com.yuwei.adsense.rec.template.parser.RecommendParser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by YuWei on 2016/10/11.
 */
public abstract class RecommendParserAdapter<T> implements RecommendParser<T> {
    private Workbook workbook;

    public List<T> parse(File file) {
        try {
            init(file);

            List<T> recommendObjectList = Lists.newArrayList();

            int sheetNum = workbook.getNumberOfSheets();
            Sheet sheet;
            for (int i = 0; i < sheetNum; i++) {
                sheet = workbook.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }
                recommendObjectList.addAll(doParse(sheet));
            }
            return recommendObjectList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    protected void init(File file) throws IOException, InvalidFormatException {
        FileInputStream ins = new FileInputStream(file);
        workbook = WorkbookFactory.create(ins);
    }

    protected List<T> doParse(Sheet sheet) {
        int rowNumber = sheet.getLastRowNum();
        List<T> recommendObjectList = Lists.newArrayList();
        T ro;
        for (int index = 1; index <= rowNumber; index++) {
            ro = doRow(sheet.getRow(index));
            if (ro == null) {
                continue;
            }
            recommendObjectList.add(ro);
        }
        return recommendObjectList;
    }

    protected Long getTimeFromString(String timeStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(timeStr).getTime();
        } catch (ParseException e) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(timeStr).getTime();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return 0l;
    }

    protected abstract T doRow(Row row);
}
