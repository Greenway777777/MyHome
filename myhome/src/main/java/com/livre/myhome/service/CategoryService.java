package com.livre.myhome.service;

import com.livre.myhome.dao.CategoryDao;
import com.livre.myhome.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // springboot 2.2版本Sort构造方法私有化了
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {
        return categoryDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        Category c= categoryDao.findById(id).orElse(null);
        return c;
    }
}
