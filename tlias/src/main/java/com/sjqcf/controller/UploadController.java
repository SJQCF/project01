package com.sjqcf.controller;

import com.sjqcf.pojo.Result;
import com.sjqcf.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    // 上传文件到本地
    /*public Result upload(String name, Integer age,@RequestParam("file") MultipartFile file) throws Exception{
        log.info("上传文件:{},{},{}",name,age,file);

        String fileName = file.getOriginalFilename();

        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;

        file.transferTo(new File("D:/images/" + fileName));
        return Result.success();
    }*/


    // 上传文件到阿里云
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator = new AliyunOSSOperator();
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件:{}",file);
        byte[] fileBytes = file.getBytes();
        String url = aliyunOSSOperator.upload(fileBytes,file.getOriginalFilename());
        return Result.success(url);
    }
}
