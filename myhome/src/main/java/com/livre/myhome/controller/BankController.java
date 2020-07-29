package com.livre.myhome.controller;

import com.livre.myhome.pojo.Bank;
import com.livre.myhome.result.Result;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @CrossOrigin
    @RequestMapping(value = "/api/banks",method = RequestMethod.GET)
    public Result queryAll(){
        return ResultFactory.buildSuccessResult(bankService.list());
    }
}
