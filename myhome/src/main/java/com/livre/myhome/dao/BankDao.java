package com.livre.myhome.dao;

import com.livre.myhome.pojo.Bank;
import com.livre.myhome.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankDao extends JpaRepository<Bank,Integer> {
    List<Bank> findAllByCategory(Category category);
    List<Bank> findAllByTitleLike(String keyword);
}
