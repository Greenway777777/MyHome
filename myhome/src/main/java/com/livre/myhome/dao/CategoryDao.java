package com.livre.myhome.dao;

import com.livre.myhome.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryDao {
    Category findById(@Param("id") int id);
}
