package com.sjqcf.controller;

import com.sjqcf.pojo.*;
import com.sjqcf.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询学生");
        PageResult<Student> result = studentService.page(studentQueryParam);
        return Result.success(result);
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学员:{}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查找学员：{}",id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员：{}",student);
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete (@PathVariable Integer[] ids){
        log.info("删除学员：{}", (Object) ids);
        studentService.delete(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable("id") Integer id, @PathVariable("score") Integer score){
        log.info("扣分：{}",score);
        studentService.violation(id,score);
        return Result.success();
    }
}
