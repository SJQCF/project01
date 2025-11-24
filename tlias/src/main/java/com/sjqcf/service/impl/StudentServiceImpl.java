package com.sjqcf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjqcf.mapper.StudentMapper;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.pojo.Student;
import com.sjqcf.pojo.StudentQueryParam;
import com.sjqcf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam){
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list = studentMapper.page();
        Page<Student> pa = (Page<Student>)list;
        return new PageResult<>(pa.getTotal(),list);
    }

    @Override
    public void save(Student student){
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        studentMapper.save(student);
    }

    @Override
    public Student findById(Integer id){
        return studentMapper.findById(id);
    }

    @Override
    public void update(Student student){
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer[] ids){
        studentMapper.delete(ids);
    }

    @Override
    public void violation(Integer id, Integer score){
        studentMapper.violation(id,score);
    }
}
