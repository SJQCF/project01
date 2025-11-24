package com.sjqcf.mapper;

import com.sjqcf.pojo.Emp;
import com.sjqcf.pojo.EmpExpr;
import com.sjqcf.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    //@Select("select e.*,d.name as deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    //查找员工数据
    public List<Emp> list(EmpQueryParam empQueryParam);

    //插入员工数据
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")//获取生成的主键
    @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
            " values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //删除员工数据
    public void deleteById(Integer[] ids);

    //根据id查询员工数据
    //@Select("select emp.*,emp_expr.* from emp left join emp_expr on emp.id = emp_expr.emp_id where emp.id = #{id}")
    public Emp findById(Integer id);

    public void update(Emp emp);

    @MapKey("job")
    public List<Map<String,Object>> countEmpJobDate();

    @MapKey("gender")
    public List<Map<String,Object>> countEmpGenderData();

    @Select("select * from emp")
    public List<Emp> findAll();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp findByUsernameAndPassword(Emp emp);
}

