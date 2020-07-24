package com.livre.myhome.dao;

import com.livre.myhome.pojo.Website;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WebsiteDao {
    List<Website> findAll();
    Website findById(@Param("id") int id);
    void addWebsite(Website website);
    void deleteByName(@Param("name") String name);
    void updateByName(Website website);
}
