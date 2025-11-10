package com.sjqcf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjqcf.mapper.EmpMapper;
import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpQueryParam;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
/**
 * page 是页码
 * pageSize 是每页展示数
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
//----------------------------旧
//    @Override
//    public PageResult<Emp> list(Integer page,Integer pageSize){
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start,pageSize);
//
//        Long total = empMapper.count();
//
//        PageResult<Emp> pageResult= new PageResult<>(total,rows);
//        return pageResult;
//    }
    @Override
    public PageResult<Emp> list(EmpQueryParam empQueryParam){
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> rows = empMapper.list(empQueryParam);
        //封装
        Page<Emp> pa = (Page<Emp>) rows;
        return new PageResult<>(pa.getTotal(),rows);
    }
}
