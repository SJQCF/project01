package com.sjqcf.service;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpQueryParam;
import com.sjqcf.pojo.LogInfo;
import com.sjqcf.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> list(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteById(Integer[] ids);

    Emp findById(Integer id);

    void update(Emp emp);

    List<Emp> findAll();

    LogInfo login(Emp emp);
}
