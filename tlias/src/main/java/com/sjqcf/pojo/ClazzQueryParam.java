package com.sjqcf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;
//    private Integer id;
//    private Integer room;
//    private Integer masterId;
//    private String masterName;
//    private LocalDateTime createTime;
//    private LocalDateTime updateTime;
//    private String status;
}
