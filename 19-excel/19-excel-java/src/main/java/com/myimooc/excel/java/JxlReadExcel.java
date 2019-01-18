package com.myimooc.excel.java;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 通过 JXL 解析 Excel 文件
 * @author ZhangCheng on 2017-07-06
 *
 */
public class JxlReadExcel {

	public static void main(String[] args) {
		try {
			read();
			System.out.println("解析成功");
		} catch (Exception e) {
			System.out.println("解析失败，异常为：" + e);
		}
	}
	
	/**
	 * 功能：解析 Excel 文件
	 * @throws Exception
	 */
	public static void read()throws Exception{
		// 指定要解析excel文件的路径
		File file = new File("d:/jxl_test.xls");
		// 创建 WorkBook，并指定路径
		Workbook workBook = Workbook.getWorkbook(file);
		// 获取工作表sheet
		Sheet sheet = workBook.getSheet(0);
		// 获取数据-循环行
		for (int i = 0; i < sheet.getRows(); i++) {
			// 循环列
			for (int j = 0; j < sheet.getColumns(); j++) {
				// 获取每一个单元格
				Cell cell = sheet.getCell(j, i);
				System.out.print(cell.getContents()+"\t");
			}
			System.out.println();
		}
		// 释放资源
		workBook.close();
	}
}
