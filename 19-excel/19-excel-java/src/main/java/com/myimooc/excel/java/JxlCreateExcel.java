package com.myimooc.excel.java;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

/**
 * 通过 JXL 创建 Excel 文件
 *
 * @author zc 2017-07-06
 */
public class JxlCreateExcel {

    public static void main(String[] args) throws Exception {
        create();
    }

    /**
     * 功能：创建 Excel 文件
     */
    private static void create() throws Exception {
        // 定义 数组存表头
        String[] title = {"id", "name", "sex"};

        // 定义Excel文件路径
        File file = new File("d://jxl_test.xls");

        // 创建工作簿
        WritableWorkbook workBook = Workbook.createWorkbook(file);
        // 创建sheet页
        WritableSheet sheet = workBook.createSheet("sheet1", 0);

        // 第一行设置表头列名
        for (int i = 0; i < title.length; i++) {
            // 几列、几行、名称
            Label label = new Label(i, 0, title[i]);
            // 往sheet页中添加单元格
            sheet.addCell(label);
        }
        // 追加数据
        int count = 10;
        for (int i = 1; i < count; i++) {
            Label label = new Label(0, i, "a" + i);
            sheet.addCell(label);
            label = new Label(1, i, "user" + i);
            sheet.addCell(label);
            label = new Label(2, i, "男");
            sheet.addCell(label);
        }
        // 写入数据
        workBook.write();
        // 释放资源
        workBook.close();
    }
}
