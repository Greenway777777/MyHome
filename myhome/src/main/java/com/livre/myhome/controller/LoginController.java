package com.livre.myhome.controller;

import com.livre.myhome.pojo.User;
import com.livre.myhome.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User user){
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if(!Objects.equals("admin",username)||!Objects.equals("123456",user.getPassword())){
            String message="账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else{
            return new Result(200);
        }
    }
}
