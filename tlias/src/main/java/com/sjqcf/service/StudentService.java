package com.sjqcf.service;

import com.sjqcf.pojo.Clazz;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.pojo.Student;
import com.sjqcf.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student findById(Integer id);

    void update(Student student);

    void delete(Integer[] ids);

    void violation(Integer id, Integer score);
}
