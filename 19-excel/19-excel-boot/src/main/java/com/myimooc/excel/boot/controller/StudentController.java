package com.myimooc.excel.boot.controller;

import com.myimooc.excel.boot.domain.model.Student;
import com.myimooc.excel.boot.service.StudentService;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

/**
 * 学生信息相关 rest 接口
 *
 * @author zc 2017-07-08
 */
@RestController
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(ImportDataController.class);

    @Autowired
    private StudentService studentService;

    /**
     * 功能：获取学生信息列表
     */
    @RequestMapping("/student/list")
    public Object studentList() {
        logger.info("获取学生信息");
        Map<String, Object> respData = new HashMap<>(1024);
        List<Student> studentList = studentService.list();
        respData.put("total", studentList.size());
        respData.put("rows", studentList);
        return respData;
    }

    /**
     * 功能：导出学生信息列表为excel
     */
    @RequestMapping("/student/export")
    public void studentExport(HttpServletResponse response) {
        String fileName = "学生信息.xls";
        String enfileName = "";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        try {
            enfileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + enfileName);

        List<Student> studentList = studentService.list();

        // 定义 数组存表头
        String[] title = {"编号", "姓名", "年龄", "性别", "出生日期", "爱好"};
        // 创建Excel工作簿
        HSSFWorkbook workBook = new HSSFWorkbook();
        // 创建工作表sheet
        HSSFSheet sheet = workBook.createSheet("学生信息");
        // 创建第一行
        HSSFRow row = sheet.createRow(0);
        // 将表头写入第一行
        for (int i = 0; i < title.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 追加数据
        for (int i = 1; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            HSSFRow nextRow = sheet.createRow(i);
            HSSFCell cell2 = nextRow.createCell(0);
            cell2.setCellValue(student.getNum());
            cell2 = nextRow.createCell(1);
            cell2.setCellValue(student.getName());
            cell2 = nextRow.createCell(2);
            cell2.setCellValue(student.getAge());
            cell2 = nextRow.createCell(3);
            cell2.setCellValue(student.getSex());
            cell2 = nextRow.createCell(4);
            cell2.setCellValue(student.getBirthday());
            cell2 = nextRow.createCell(5);
            cell2.setCellValue(student.getHobby());
        }

        URL resource = getClass().getClassLoader().getResource("config/excel/");
        if (Objects.isNull(resource)) {
            throw new RuntimeException("资源不存在");
        }

        String filePath = resource.getPath();
        File excelFile = new File(filePath + fileName);

        try {
            // 将Excel内容写入文件
            FileOutputStream stream = FileUtils.openOutputStream(excelFile);
            workBook.write(stream);
            // 释放资源
            stream.close();
            workBook.close();
            logger.info("创建成功：{}", excelFile.getName());
            InputStream in = FileUtils.openInputStream(excelFile);
            int b;
            while ((b = in.read()) != -1) {
                response.getOutputStream().write(b);
            }
        } catch (Exception ex) {
            logger.error("创建失败：", ex);
        }
    }
}
