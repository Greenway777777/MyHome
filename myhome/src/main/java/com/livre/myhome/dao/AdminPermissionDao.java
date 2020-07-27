package com.livre.myhome.dao;

import com.livre.myhome.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminPermissionDao extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
