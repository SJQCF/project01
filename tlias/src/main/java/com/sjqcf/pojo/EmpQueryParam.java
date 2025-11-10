package com.sjqcf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer gender;
    private LocalDate begin;
    private LocalDate end;
}
