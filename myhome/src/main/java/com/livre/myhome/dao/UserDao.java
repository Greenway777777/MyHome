package com.livre.myhome.dao;

import com.livre.myhome.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> findAllUser();

    void addUser(User user);

    void updateUserById(User user);

    void deleteUserById(User user);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);

    User findByUsername(@Param("username")String username);

}
