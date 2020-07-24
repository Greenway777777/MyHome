package com.livre.myhome.service;

import com.livre.myhome.dao.CategoryDao;
import com.livre.myhome.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public Category getById(int id){
        return categoryDao.findById(id);
    }
}
