package com.sjqcf.controller;

import com.sjqcf.pojo.Dept;
import com.sjqcf.pojo.result;
import com.sjqcf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public result list(){
        System.out.println("查询所有部门");
        List<Dept> depts = deptService.findAll();
        return result.success(depts);
    }
}
