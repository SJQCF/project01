package com.sjqcf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sjqcf.mapper.EmpExprMapper;
import com.sjqcf.mapper.EmpMapper;
import com.sjqcf.pojo.*;
import com.sjqcf.service.EmpService;
import com.sjqcf.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * page 是页码
 * pageSize 是每页展示数
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
//----------------------------旧
//    @Override
//    public PageResult<Emp> list(Integer page,Integer pageSize){
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start,pageSize);
//
//        Long total = empMapper.count();
//
//        PageResult<Emp> pageResult= new PageResult<>(total,rows);
//        return pageResult;
//    }
    @Override
    public PageResult<Emp> list(EmpQueryParam empQueryParam){
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> rows = empMapper.list(empQueryParam);
        //封装
        Page<Emp> pa = (Page<Emp>) rows;
        return new PageResult<>(pa.getTotal(),rows);
    }

    @Transactional//事务 默认是运行时异常
    @Override
    public void save(Emp emp) {
        //插入员工基本数据
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.insert(emp);

        //插入员工工作经历
        List<EmpExpr> empExprs = emp.getExprList();
        if (!CollectionUtils.isEmpty(empExprs)) {
            empExprs.forEach(empexpr -> {
                empexpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empExprs);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer[] ids){
        //删除员工基本数据
        empMapper.deleteById(ids);
        //删除员工工作经历
        empExprMapper.deleteById(ids);

    }

    @Override
    public Emp findById(Integer id){
        Emp emp = empMapper.findById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        //1. 更新员工基本数据
        empMapper.update(emp);

        //2. 删除员工工作经历
        empExprMapper.deleteById(new Integer[]{emp.getId()});

        //3. 插入员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> findAll(){
        return empMapper.findAll();
    }

    @Override
    public LogInfo login(Emp emp){
        Emp e = empMapper.findByUsernameAndPassword(emp);
        if(e != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            String token = JwtUtils.generateJwt(claims);
            return new LogInfo(e.getId(),e.getUsername(),e.getName(),token);
        }
        return null;
    }
}
