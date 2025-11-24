package com.sjqcf.controller;


import com.sjqcf.pojo.Clazz;
import com.sjqcf.pojo.ClazzQueryParam;
import com.sjqcf.pojo.PageResult;
import com.sjqcf.pojo.Result;
import com.sjqcf.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result getClazzs(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询:{}",clazzQueryParam);
        PageResult<Clazz> list = clazzService.getClazzs(clazzQueryParam);
        return Result.success(list);
    }

    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级:{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id){
        log.info("根据id查询：{}",id);
        return Result.success(clazzService.getClazzById(id));
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级:{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除班级:{}",id);
        clazzService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> list = clazzService.findAll();
        return Result.success(list);
    }
}
