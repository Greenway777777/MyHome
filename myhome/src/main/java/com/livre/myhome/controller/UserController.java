package com.livre.myhome.controller;

import com.livre.myhome.pojo.User;
import com.livre.myhome.result.Result;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.AdminUserRoleService;
import com.livre.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.getAll());
    }

//    @PutMapping("/api/admin/user/status")
//    public Result updateUserStatus(@RequestBody User requestUser) {
//        userService.updateUserStatus(requestUser);
//        return ResultFactory.buildSuccessResult("用户状态更新成功");
//    }
//
//    @PutMapping("/api/admin/user/password")
//    public Result resetPassword(@RequestBody User requestUser) {
//        userService.resetPassword(requestUser);
//        return ResultFactory.buildSuccessResult("重置密码成功");
//    }
//
//    @PutMapping("/api/admin/user")
//    public Result editUser(@RequestBody User requestUser) {
//        userService.editUser(requestUser);
//        return ResultFactory.buildSuccessResult("修改用户信息成功");
//    }
}
