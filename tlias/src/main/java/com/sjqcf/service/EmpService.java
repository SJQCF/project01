package com.sjqcf.service;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpQueryParam;
import com.sjqcf.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> list(EmpQueryParam empQueryParam);
}
