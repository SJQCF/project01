package com.sjqcf.controller;

import com.sjqcf.pojo.JobOption;
import com.sjqcf.pojo.Result;
import com.sjqcf.pojo.StudentOption;
import com.sjqcf.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result countEmpJobDate(){
        log.info("报表统计");
        JobOption jobOption = reportService.countEmpJobDate();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result countEmpGenderData(){
        log.info("报表统计性别");
        List<Map<String,Object>> list = reportService.countEmpGenderData();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result countStudentCountData(){
        log.info("报表统计班级人数");
        StudentOption studentOption = reportService.countStudentCountData();
        return Result.success(studentOption);
    }

    @GetMapping("/studentDegreeData")
    public Result countStudentDegreeData(){
        log.info("报表统计班级学历");
        List<Map<String,Object>> list = reportService.countStudentDegreeData();
        return Result.success(list);
    }
}
