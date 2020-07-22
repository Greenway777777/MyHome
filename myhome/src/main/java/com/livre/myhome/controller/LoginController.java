package com.livre.myhome.controller;

import com.livre.myhome.pojo.User;
import com.livre.myhome.result.Result;
import com.livre.myhome.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        System.out.println(username);

        User user=userService.getByUsernameAndPassword(username,requestUser.getPassword());

        if(null == user){
            String message="账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else{
            return new Result(200);
        }
    }
}
