package com.sjqcf.service;

import com.sjqcf.pojo.JobOption;
import com.sjqcf.pojo.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    public JobOption countEmpJobDate();

    public List<Map<String,Object>> countEmpGenderData();

    public StudentOption countStudentCountData();

    List<Map<String, Object>> countStudentDegreeData();
}
