package com.sjqcf.controller;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpQueryParam;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.pojo.Result;
import com.sjqcf.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam (defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
//    ){
//        log.info("分页查询:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult = empService.list(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询:{}",empQueryParam);
        PageResult<Emp> pageResult = empService.list(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteById(Integer[] ids){
        log.info("删除员工信息：{}", Arrays.toString(ids));
        empService.deleteById(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询员工：{}",id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工:{}",emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有员工");
        List<Emp> list = empService.findAll();
        return Result.success(list);
    }
}
