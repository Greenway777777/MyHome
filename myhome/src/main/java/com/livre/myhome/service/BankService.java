package com.livre.myhome.service;

import com.livre.myhome.dao.BankDao;
import com.livre.myhome.pojo.Bank;
import com.livre.myhome.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    BankDao bankDao;
    @Autowired
    CategoryService categoryService;

    public List<Bank> list() {
        return bankDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void addOrUpdate(Bank bank) {
        bankDao.save(bank);
    }

    public void deleteById(int id) {
        bankDao.deleteById(id);
    }

    public List<Bank> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bankDao.findAllByCategory(category);
    }

    public List<Bank> Search(String keywords) {
        return bankDao.findAllByTitleLike('%' + keywords + '%');
    }
}
