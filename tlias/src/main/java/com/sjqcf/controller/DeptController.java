package com.sjqcf.controller;

import com.sjqcf.pojo.Dept;
import com.sjqcf.pojo.Result;
import com.sjqcf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查询所有部门
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result list(){
        System.out.println("查询所有部门");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    //删除部门
    @DeleteMapping(value = "/depts")
    public Result delete(@RequestParam("id") Integer id){
        System.out.println("删除部门" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    //添加部门
    @PostMapping(value = "/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门" + dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询部门
    @GetMapping(value = "/depts/{id}")
    public Result findById(@PathVariable("id") Integer id){
        System.out.println("查询到的部门id" + id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
