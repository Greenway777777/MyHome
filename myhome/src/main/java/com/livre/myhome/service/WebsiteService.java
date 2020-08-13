package com.livre.myhome.service;

import com.livre.myhome.dao.WebsiteDao;
import com.livre.myhome.pojo.Bank;
import com.livre.myhome.pojo.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteService {
    @Autowired
    WebsiteDao websiteDao;

    public List<Website> list() {
        return websiteDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
    public void addOrUpdate(Website website) {
        websiteDao.save(website);
    }

    public void deleteById(int id) {
        websiteDao.deleteById(id);
    }
//    public List<Website> getAll(){
//        return websiteDao.findAll();
//    }
}
