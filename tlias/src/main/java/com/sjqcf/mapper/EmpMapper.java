package com.sjqcf.mapper;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /*
    //查询总数据数
    @Select("Select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();

    //
    @Select("select e.*,d.name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start} , #{pageSize}")
    public List<Emp> list(@RequestParam("start") Integer start,@RequestParam("pageSize") Integer pageSize);
    */

    //@Select("select e.*,d.name as deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> list(EmpQueryParam empQueryParam);
    }

