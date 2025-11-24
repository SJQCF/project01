package com.sjqcf.mapper;

import com.sjqcf.pojo.Clazz;
import com.sjqcf.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
    public List<Clazz> getClazzs(ClazzQueryParam clazzQueryParam);

    public void save(Clazz clazz);

    public Clazz getClazzById(Integer id);

    public void update(Clazz clazz);

    public void delete(Integer id);

    Integer findClaHasStu(Integer id);

    List<Clazz> findAll();
}
