package com.test.java.util.poi;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiaogu on 2017/1/8.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("e:\\1.xls"));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        Iterator<Row> iterator = sheetAt.iterator();
        NumberFormat numberFormat = NumberFormat.getInstance();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Map<String,String> map = new HashMap<String,String>();
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        numberFormat.setGroupingUsed(false);
                        System.out.println(numberFormat.format(cell.getNumericCellValue()));
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        numberFormat.setGroupingUsed(false);
                        System.out.println(numberFormat.format(cell.getNumericCellValue()));
                        break;
                    default:
                        System.out.println("unsuported sell type");
                }
            }
        }
    }
}