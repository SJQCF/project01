package com.sjqcf.mapper;

import com.sjqcf.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> page();

    void save(Student student);

    Student findById(Integer id);

    void update(Student student);

    void delete(Integer[] ids);

    void violation(Integer id, Integer score);

    @MapKey("clazzList")
    List<Map<String, Object>> countStudentCountData();

    List<Map<String, Object>> countStudentDegreeData();
}
