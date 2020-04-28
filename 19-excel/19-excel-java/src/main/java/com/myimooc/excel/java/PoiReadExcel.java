package com.myimooc.excel.java;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;

/**
 * 通过 POI 解析 Excel 文件
 *
 * @author zc 2017-07-06
 */
public class PoiReadExcel {

    public static void main(String[] args) throws Exception {
        read();
    }

    /**
     * 功能：解析 Excel 文件
     */
    private static void read() throws Exception {
        // 指定需要解析excel文件的路径
        File file = new File("d:/poi_test.xls");

        // 创建工作簿
        HSSFWorkbook workBook = new HSSFWorkbook(FileUtils.openInputStream(file));
        // 读取sheet页
        HSSFSheet sheet = workBook.getSheetAt(0);

        // 读取工作表中的数据
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        for (int i = firstRowNum; i < lastRowNum; i++) {
            // 循环读取每一行数据
            HSSFRow row = sheet.getRow(i);
            // 获取当前行最后单元格列号
            int lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                // 循环读取当前行中的每一个单元格
                HSSFCell cell = row.getCell(j);
                String value = cell.getStringCellValue();
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        // 释放资源
        workBook.close();
    }
}
