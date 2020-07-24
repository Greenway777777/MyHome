package com.livre.myhome.dao;

import com.livre.myhome.pojo.Bank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankDao {

    List<Bank> findAll();
}
