package com.livre.myhome.service;

import com.livre.myhome.dao.BankDao;
import com.livre.myhome.pojo.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    BankDao bankDao;

    public List<Bank> getAll(){
        return bankDao.findAll();
    }
}
