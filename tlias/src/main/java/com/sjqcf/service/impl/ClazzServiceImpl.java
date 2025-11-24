package com.sjqcf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjqcf.exception.MyException;
import com.sjqcf.mapper.ClazzMapper;
import com.sjqcf.mapper.EmpMapper;
import com.sjqcf.pojo.Clazz;
import com.sjqcf.pojo.ClazzQueryParam;
import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> getClazzs(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.getClazzs(clazzQueryParam);
        list.forEach(clazz-> {
            LocalDate time = LocalDate.now();
            if(time.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结班");
            }
            if(time.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            }
            if(time.isAfter(clazz.getBeginDate()) && time.isBefore(clazz.getEndDate())) {
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> pa = (Page<Clazz>) list;
        return new PageResult<>(pa.getTotal(),list);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id){
        int c = clazzMapper.findClaHasStu(id);
        if(c > 0) {
            throw new MyException("班级下有学生,不能删除");
        }
        clazzMapper.delete(id);
    }

    @Override
    public List<Clazz> findAll(){
        return clazzMapper.findAll();
    }
}
