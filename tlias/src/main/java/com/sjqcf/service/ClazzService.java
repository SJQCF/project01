package com.sjqcf.service;


import com.sjqcf.pojo.Clazz;
import com.sjqcf.pojo.ClazzQueryParam;
import com.sjqcf.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    public PageResult<Clazz> getClazzs(ClazzQueryParam clazzQueryParam);

    public void save(Clazz clazz);

    public Clazz getClazzById(Integer id);

    public void update(Clazz clazz);

    public void delete(Integer id);

    List<Clazz> findAll();
}
