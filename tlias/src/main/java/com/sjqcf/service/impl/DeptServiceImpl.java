package com.sjqcf.service.impl;

import com.sjqcf.mapper.DeptMapper;
import com.sjqcf.pojo.Dept;
import com.sjqcf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll(){
        List<Dept> depts= deptMapper.findAll();
        return depts;
    }
}
