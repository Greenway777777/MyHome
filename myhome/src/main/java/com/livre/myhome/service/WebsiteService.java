package com.livre.myhome.service;

import com.livre.myhome.dao.WebsiteDao;
import com.livre.myhome.pojo.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteService {
    @Autowired
    WebsiteDao websiteDao;

    public List<Website> getAll(){
        return websiteDao.findAll();
    }
}
