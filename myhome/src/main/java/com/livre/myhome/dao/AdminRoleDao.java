package com.livre.myhome.dao;

import com.livre.myhome.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleDao extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}

