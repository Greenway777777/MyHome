package com.livre.myhome.controller;

import com.livre.myhome.pojo.Bank;
import com.livre.myhome.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @RequestMapping(value = "/api/banks",method = RequestMethod.GET)
    public List<Bank> queryAll(){
        return bankService.getAll();
    }
}
