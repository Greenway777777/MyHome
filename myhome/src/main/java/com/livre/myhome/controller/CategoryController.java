package com.livre.myhome.controller;

import com.livre.myhome.pojo.Category;
import com.livre.myhome.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/api/category",method = RequestMethod.GET)
    public Category queryById(@RequestParam("id") int id){
        return categoryService.get(id);
    }
}
