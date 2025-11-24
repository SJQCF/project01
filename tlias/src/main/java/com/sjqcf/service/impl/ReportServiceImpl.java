package com.sjqcf.service.impl;

import com.sjqcf.mapper.ClazzMapper;
import com.sjqcf.mapper.EmpMapper;
import com.sjqcf.mapper.StudentMapper;
import com.sjqcf.pojo.JobOption;
import com.sjqcf.pojo.StudentOption;
import com.sjqcf.service.ClazzService;
import com.sjqcf.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption countEmpJobDate() {
        List<Map<String,Object>> list = empMapper.countEmpJobDate();
        List<Object> jobList = list.stream().map(map -> map.get("job")).toList();
        List<Object> dataList = list.stream().map(map -> map.get("date")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String,Object>> countEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public StudentOption countStudentCountData(){
        List<Map<String,Object>> list = studentMapper.countStudentCountData();
        List<Object> clazzs = list.stream().map(map -> map.get("clazz")).toList();
        List<Object> counts = list.stream().map(map -> map.get("count")).toList();
        return new StudentOption(clazzs,counts);
    }

    @Override
    public List<Map<String,Object>> countStudentDegreeData(){
        return studentMapper.countStudentDegreeData();
    }
}
