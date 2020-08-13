package com.livre.myhome.controller;

import com.livre.myhome.pojo.AdminMenu;
import com.livre.myhome.result.Result;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public Result menu() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
    }

//    @GetMapping("/api/menu")
//    public List<AdminMenu> menu() {
//        return adminMenuService.getMenusByCurrentUser();
//    }
    @GetMapping("/api/admin/role/menu")
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }
}
