package com.sjqcf.service;

import com.sjqcf.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
