package com.sjqcf.mapper;

import com.sjqcf.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> empExprs);

    void deleteById(Integer[] ids);
}
