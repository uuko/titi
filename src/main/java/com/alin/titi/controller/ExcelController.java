package com.alin.titi.controller;

import com.alin.titi.model.api.response.BookResponse;
import com.alin.titi.model.base.ExcelExporter;
import com.alin.titi.model.export.ExportTeacherResponse;
import com.alin.titi.services.BookServices;
import com.alin.titi.services.ExportServices;
import com.alin.titi.services.LoginServices;
import com.alin.titi.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ExcelController {
    @Autowired
    private BookServices bookServices;
    @Autowired
    private LoginServices loginServices;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ExportServices exportServices;

    @GetMapping("/teacher/export/excel/book")
    public void exportToExcel(HttpServletResponse response,@RequestParam("loginId") Integer loginId) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<BookResponse> listUsers = bookServices.findAllBookData(loginId);

        ExcelExporter excelExporter = new ExcelExporter(listUsers);

        excelExporter.export(response);
    }

    // teacher list B & C
    @GetMapping("/teacher/export/list")
    public ResponseEntity<?> listExportTeacher(){
        List<ExportTeacherResponse> responseList=  exportServices.findTeacherExportList();
        if (responseList.size()>0){
            return ResponseEntity.ok(responseList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teacher/export/table")
    public ResponseEntity<?> listExportTable(@RequestParam("loginId") Integer loginId){
        List<String> responseList=  exportServices.findTableExportList(loginId);
        if (responseList.size()>0){
            return ResponseEntity.ok(responseList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teacher/export/semester")
    public ResponseEntity<?> listExportYearAndSemester(@RequestParam("loginId") Integer loginId
                                                       ,@RequestParam("tableName") String tableName){
        List<String> responseList=  exportServices.findSemesterAndYearExportList(loginId,tableName);
        if (responseList.size()>0){
            return ResponseEntity.ok(responseList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
