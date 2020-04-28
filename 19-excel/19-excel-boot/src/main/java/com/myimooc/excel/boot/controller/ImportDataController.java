package com.myimooc.excel.boot.controller;

import com.myimooc.excel.boot.domain.model.ImportData;
import com.myimooc.excel.boot.domain.model.ImportDataDetail;
import com.myimooc.excel.boot.domain.vo.Template;
import com.myimooc.excel.boot.service.ImportDataDetailService;
import com.myimooc.excel.boot.service.ImportDataService;
import com.myimooc.excel.boot.util.CreateTemplateUtils;
import com.myimooc.excel.boot.util.DateUtils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

/**
 * 数据导入相关 rest 接口
 *
 * @author zc 2017-07-08
 */
@RestController
public class ImportDataController {

    private final Logger logger = LoggerFactory.getLogger(ImportDataController.class);

    @Autowired
    private ImportDataService importDataService;
    @Autowired
    private ImportDataDetailService importDataDetailService;

    /**
     * 功能：获取导入列表数据
     */
    @RequestMapping("/import/data/list")
    public Object importDataList() {
        return importDataService.list();
    }

    /**
     * 功能：获取导入数据模版
     */
    @RequestMapping("/import/data/templates")
    public Object importDataTemplates() {
        List<Template> list = new ArrayList<>(4);
        Template t = new Template();
        t.setTemplateId("student");
        t.setTemplateName("student");
        list.add(t);
        return list;
    }

    /**
     * 功能：数据导入
     */
    @PostMapping("/import/data/upload")
    public Object importDataUpload(MultipartFile file) {
        if (Objects.isNull(file)) {
            return "上传失败，文件为空";
        }

        try {
            String fileName = file.getName();
            URL resource = getClass().getClassLoader().getResource("config/excel/");
            if (Objects.isNull(resource)) {
                return "获取资源路径失败";
            }
            String filePath = resource.getPath() + fileName;
            File excelFile = new File(filePath);
            FileUtils.writeByteArrayToFile(excelFile, file.getBytes());

            // 保存导入数据任务
            ImportData importData = new ImportData();
            Long importDataId = DateUtils.getTimeInstant();
            importData.setId(importDataId);
            importData.setImportDataType("student");
            importData.setImportStatus(1 + "");
            importData.setImportDate(DateUtils.nowToString());
            importDataService.save(importData);

            // 保存导入数据明细
            List<ImportDataDetail> importDataDetailList = buildImportDateDetailList(file, importDataId);
            importDataDetailService.save(importDataDetailList);

            importData = importDataService.findOne(importDataId);
            importData.setDealDate(DateUtils.nowToString());
            importData.setDealStatus(1 + "");
            importDataService.save(importData);

            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    private List<ImportDataDetail> buildImportDateDetailList(MultipartFile file, Long importDataId) throws IOException {
        // 创建工作簿
        HSSFWorkbook workBook = new HSSFWorkbook(file.getInputStream());
        // 读取sheet页
        HSSFSheet sheet = workBook.getSheetAt(0);
        // 读取工作表中的数据
        int firstRowNum = 1;
        int lastRowNum = sheet.getLastRowNum();
        List<ImportDataDetail> importDataDetailList = new ArrayList<>(lastRowNum);

        for (int i = firstRowNum; i < lastRowNum; i++) {
            // 循环读取每一行数据
            HSSFRow row = sheet.getRow(i);
            // 获取当前行最后单元格列号
            int lastCellNum = row.getLastCellNum();
            ImportDataDetail importDataDetail = new ImportDataDetail();
            for (int j = 0; j < lastCellNum; j++) {
                // 循环读取当前行中的每一个单元格
                HSSFCell cell = row.getCell(j);

                String value;

                if (CellType.NUMERIC == cell.getCellType()) {
                    value = cell.getNumericCellValue() + "";
                    System.out.print(value + "\t");
                } else {
                    value = cell.getStringCellValue();
                    System.out.print(value + "\t");
                }
                System.out.print(value + "\t");

                switch (j) {
                    case 0:
                        importDataDetail.setCol0(value);
                        break;
                    case 1:
                        importDataDetail.setCol1(value);
                        break;
                    case 2:
                        importDataDetail.setCol2(value);
                        break;
                    case 3:
                        importDataDetail.setCol3(value);
                        break;
                    case 4:
                        importDataDetail.setCol4(value);
                        break;
                    case 5:
                        importDataDetail.setCol5(value);
                        break;
                    case 6:
                        importDataDetail.setCol6(value);
                    default:
                        break;
                }
                importDataDetail.setDealStatus(1 + "");
                importDataDetail.setImportId(importDataId);
                importDataDetail.setId(DateUtils.getTimeInstant() + Math.round(DateUtils.getTimeInstant()));
            }
            System.out.println();
            importDataDetailList.add(importDataDetail);

        }
        // 释放资源
        workBook.close();
        // 返回数据明细列表
        return importDataDetailList;
    }

    /**
     * 功能：下载导入数据模版
     */
    @RequestMapping("download")
    public void download(HttpServletResponse response) {
        String fileName = "student.xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        URL xmlResource = getClass().getClassLoader().getResource("config/excel/student.xml");
        if (Objects.isNull(xmlResource)) {
            logger.error("获取资源路径失败");
            return;
        }
        URL fileResource = getClass().getClassLoader().getResource("config/excel/");
        if (Objects.isNull(fileResource)) {
            logger.error("获取资源路径失败");
            return;
        }

        File xmlFile = new File(xmlResource.getPath());
        File excelFile = new File(fileResource.getPath() + fileName);
        try {
            CreateTemplateUtils.create(xmlFile, excelFile);
            logger.info("创建成功：{}", excelFile.getName());
            InputStream in = FileUtils.openInputStream(excelFile);
            int b;
            while ((b = in.read()) != -1) {
                response.getOutputStream().write(b);
            }
        } catch (Exception ex) {
            logger.warn("创建失败：", ex);
        }
    }
}
