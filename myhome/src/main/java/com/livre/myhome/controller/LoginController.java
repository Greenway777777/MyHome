package com.livre.myhome.controller;

import com.livre.myhome.pojo.User;
import com.livre.myhome.result.Result;
import com.livre.myhome.result.ResultFactory;
import com.livre.myhome.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true); // rememberMe
//        System.out.println(subject.isRemembered());
//        System.out.println(subject.isAuthenticated());
        try {
            subject.login(usernamePasswordToken); // 验证token令牌
            User user = userService.findByUsername(username);
            if (!user.isEnabled()) {
                return ResultFactory.buildFailResult("该用户已被禁用");
            }
            return ResultFactory.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }

//        User user=userService.getByUsernameAndPassword(username,requestUser.getPassword());
//        if(null == user){
//            String message="账号密码错误";
//            return new Result(400);
//        } else{
//            return new Result(200);
//        }
    }

    @PostMapping("/api/register")
    public Result register(@RequestParam User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }



}
