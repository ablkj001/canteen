package com.cuit.service;

import com.cuit.pojo.User;
import com.cuit.util.LoginResultEnum;

import java.util.List;

public interface UserService {

    List<User> queryUserList();

    User queryUserById(Integer uid);

    Integer updateUser(User user);

    Integer deleteUser(Integer Uid);

    User queryUserByUame(String uname);

    public LoginResultEnum checkLogin(User user);
}
