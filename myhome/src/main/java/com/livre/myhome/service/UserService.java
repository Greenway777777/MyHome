package com.livre.myhome.service;

import com.livre.myhome.dao.UserDao;
import com.livre.myhome.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean isExist(String username){
        User user=getByUsername(username);
        return null!=user;
    }

    public List<User> getAll(){
        return userDao.findAllUser();
    }

    public User getByUsername(String username){
        return userDao.findByUsername(username);
    }

    public User getByUsernameAndPassword(String username,String password){
        return userDao.findByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDao.addUser(user);
    }

}
