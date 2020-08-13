package com.livre.myhome.dao;

import com.livre.myhome.pojo.Bank;
import com.livre.myhome.pojo.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebsiteDao extends JpaRepository<Website,Integer> {
//    List<Bank> findAllByTitleLike(String keyword);
//    List<Website> findAll();
//    Website findById(@Param("id") int id);
//    void addWebsite(Website website);
//    void deleteByName(@Param("name") String name);
//    void updateByName(Website website);
}
