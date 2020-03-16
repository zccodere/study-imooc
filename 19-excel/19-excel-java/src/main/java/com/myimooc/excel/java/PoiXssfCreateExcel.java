package com.myimooc.excel.java;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 通过 POI 的 XSSF 创建高版本的  Excel 文件
 *
 * @author zc 2017-07-06
 */
public class PoiXssfCreateExcel {

    public static void main(String[] args) throws Exception {
        create();
    }

    /**
     * 功能：创建 Excel 文件
     */
    private static void create() throws Exception {

        // 定义Excel文件路径
        File file = new File("d:/poi_sxxf_test.xlsx");

        // 定义 数组存表头
        String[] title = {"id", "name", "sex"};
        // 创建Excel工作簿
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 创建工作表sheet
        XSSFSheet sheet = workBook.createSheet();
        // 创建第一行
        XSSFRow row = sheet.createRow(0);
        // 将表头写入第一行
        for (int i = 0; i < title.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 追加数据
        int count = 10;
        for (int i = 1; i < count; i++) {
            XSSFRow nextRow = sheet.createRow(i);
            XSSFCell cell2 = nextRow.createCell(0);
            cell2.setCellValue("a" + i);
            cell2 = nextRow.createCell(1);
            cell2.setCellValue("user" + i);
            cell2 = nextRow.createCell(2);
            cell2.setCellValue("男");
        }
        // 将Excel内容写入文件
        FileOutputStream stream = FileUtils.openOutputStream(file);
        workBook.write(stream);
        // 释放资源
        stream.close();
        workBook.close();
    }
}
