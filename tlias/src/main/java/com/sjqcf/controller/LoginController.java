package com.sjqcf.controller;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.LogInfo;
import com.sjqcf.pojo.Result;
import com.sjqcf.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        LogInfo logInfo = empService.login(emp);
        if(logInfo != null){
            return Result.success(logInfo);
        }
        else{
            return Result.error("用户名或密码错误");
        }
    }
}
