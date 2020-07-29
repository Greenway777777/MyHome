package com.livre.myhome.dao;

import com.livre.myhome.pojo.BlogPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPageDao extends JpaRepository<BlogPage,Integer> {
    BlogPage findById(int id);
}
