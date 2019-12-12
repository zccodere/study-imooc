package com.myimooc.excel.boot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * 创建 Excel 模版文件
 *
 * @author ZhangCheng on 2017-07-06
 */
public class CreateTemplate {

    public static void main(String[] args) {
        try {
            create();
            System.out.println("创建成功");
        } catch (Exception e) {
            System.out.println("创建失败，异常为：" + e);
            e.printStackTrace();
        }
    }

    /**
     * 功能：创建 Excel 模版文件
     *
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static void create() throws Exception {

        // 获取项目根路径
        String rootPath = System.getProperty("user.dir");
        // 获取解析xml文件路径
        String path = rootPath + "/src/main/resources/student2.xml";
        System.out.println(path);

        File file = new File(path);

        // 解析xml文件
        SAXBuilder builder = new SAXBuilder();
        Document parse = builder.build(file);
        // 创建excel
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = wb.createSheet("sheet0");

        // 获取xml文件根节点
        Element root = parse.getRootElement();
        // 获取模版名称
        String templateName = root.getAttribute("name").getValue();

        int rownum = 0;
        int column = 0;

        // 设置列宽
        Element colgroup = root.getChild("colgroup");
        setColumnWidth(sheet, colgroup);

        // 设置标题
        Element title = root.getChild("title");
        List<Element> trs = title.getChildren("tr");
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            List<Element> tds = tr.getChildren("td");
            // 创建一行
            HSSFRow row = sheet.createRow(rownum);
            // 设置样式
            HSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            for (column = 0; column < tds.size(); column++) {
                Element td = tds.get(column);
                // 创建单元格
                HSSFCell cell = row.createCell(column);
                Attribute rowSpan = td.getAttribute("rowspan");
                Attribute colSpan = td.getAttribute("colspan");
                Attribute value = td.getAttribute("value");
                if (value != null) {
                    String val = value.getValue();
                    cell.setCellValue(val);

                    int rspan = rowSpan.getIntValue() - 1;
                    int cspan = colSpan.getIntValue() - 1;

                    // 设置字体
                    HSSFFont font = wb.createFont();
                    // 字体格式
                    font.setFontName("仿宋_GB2312");
                    // 字体加粗
                    font.setBold(true);
                    //font.setFontHeight((short) 12);// 字体大小
                    font.setFontHeightInPoints((short) 12);
                    cellStyle.setFont(font);
                    cell.setCellStyle(cellStyle);
                    // 合并单元格
                    sheet.addMergedRegion(new CellRangeAddress(rspan, rspan, 0, cspan));
                }
            }
            rownum++;
        }

        // 设置表头
        Element thead = root.getChild("thead");
        trs = thead.getChildren("tr");
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            HSSFRow row = sheet.createRow(rownum);
            List<Element> ths = tr.getChildren("th");
            for (column = 0; column < ths.size(); column++) {
                Element th = ths.get(column);
                Attribute valueAttr = th.getAttribute("value");
                HSSFCell cell = row.createCell(column);
                if (valueAttr != null) {
                    String value = valueAttr.getValue();
                    cell.setCellValue(value);
                }
            }
            rownum++;
        }

        // 设置数据区域样式
        Element tbody = root.getChild("tbody");
        Element tr = tbody.getChild("tr");
        int repeat = tr.getAttribute("repeat").getIntValue();

        List<Element> tds = tr.getChildren("td");
        for (int i = 0; i < repeat; i++) {
            HSSFRow row = sheet.createRow(rownum);
            for (column = 0; column < tds.size(); column++) {
                Element td = tds.get(column);
                HSSFCell cell = row.createCell(column);
                setType(wb, cell, td);
            }
            rownum++;
        }

        // 生成excel导入模版
        File templateFile = new File("d:/" + templateName + ".xls");
        templateFile.delete();
        templateFile.createNewFile();
        FileOutputStream stream = FileUtils.openOutputStream(templateFile);
        wb.write(stream);
        stream.close();
    }

    /**
     * 功能：设置单元格样式
     *
     * @param wb
     * @param cell
     * @param td
     */
    @SuppressWarnings("deprecation")
    private static void setType(HSSFWorkbook wb, HSSFCell cell, Element td) {
        String attrTypeString = "STRING";
        String attrTypeNumeric = "NUMERIC";
        String attrTypeDate = "DATE";
        String attrTypeEnum = "ENUM";
        Attribute typeAttr = td.getAttribute("type");
        String type = typeAttr.getValue();
        HSSFDataFormat format = wb.createDataFormat();
        HSSFCellStyle cellStyle = wb.createCellStyle();
        if (attrTypeNumeric.equalsIgnoreCase(type)) {
            cell.setCellType(CellType.NUMERIC);
            Attribute formatAttr = td.getAttribute("format");
            String formatValue = formatAttr.getValue();
            formatValue = StringUtils.isNoneBlank(formatValue) ? formatValue : "#,##0.00";
            cellStyle.setDataFormat(format.getFormat(formatValue));
        } else if (attrTypeString.equalsIgnoreCase(type)) {
            cell.setCellValue("");
            cell.setCellType(CellType.STRING);
            cellStyle.setDataFormat(format.getFormat("@"));
        } else if (attrTypeDate.equalsIgnoreCase(type)) {
            cell.setCellType(CellType.NUMERIC);
            cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
        } else if (attrTypeEnum.equalsIgnoreCase(type)) {
            CellRangeAddressList regions =
                    new CellRangeAddressList(cell.getRowIndex(),
                            cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex());
            Attribute enumAttr = td.getAttribute("format");
            String enumValue = enumAttr.getValue();
            // 加载下拉列表内容
            DVConstraint constraint =
                    DVConstraint.createExplicitListConstraint(enumValue.split(","));
            // 数据有效性对象
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            wb.getSheetAt(0).addValidationData(dataValidation);
        }
        cell.setCellStyle(cellStyle);
    }

    /**
     * 功能：设置工作表列宽
     *
     * @param sheet    工作表
     * @param colgroup
     */
    private static void setColumnWidth(HSSFSheet sheet, Element colgroup) {
        List<Element> cols = colgroup.getChildren("col");
        for (int i = 0; i < cols.size(); i++) {
            // 获取每一列的设置
            Element col = cols.get(i);
            Attribute width = col.getAttribute("width");
            // 宽度单位
            String unit = width.getValue().replaceAll("[0-9,\\.]", "");
            String value = width.getValue().replaceAll(unit, "");
            int v = 0;
            if (StringUtils.isBlank(unit) || "px".equals(unit)) {
                v = Math.round(Float.parseFloat(value) * 37F);
            } else if ("em".endsWith(unit)) {
                v = Math.round(Float.parseFloat(value) * 267.5F);
            }
            // 设置宽度
            sheet.setColumnWidth(i, v);
        }
    }
}
