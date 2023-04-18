package com.cuit.service.Impl;

import com.cuit.mapper.UserMapper;
import com.cuit.pojo.User;
import com.cuit.service.UserService;
import com.cuit.util.LoginResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    LoginResultEnum loginResultEnum = null;

    @Override
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();
        return users;
    }

    @Override
    public User queryUserById(Integer uid) {
        User user = userMapper.queryUserById(uid);
        return user;
    }

    @Override
    public Integer updateUser(User user) {
        Integer i = userMapper.updateUser(user);
        return i;
    }

    @Override
    public Integer deleteUser(Integer uid) {
        Integer i = userMapper.deleteUser(uid);
        return i;
    }

    @Override
    public User queryUserByUame(String uname) {
        User user = userMapper.queryUserByUname(uname);
        return user;
    }

    @Override
    public LoginResultEnum checkLogin(User user) {
        User user_r = userMapper.queryUserByUname(user.getUname());
        if (user_r==null){
            loginResultEnum = LoginResultEnum.USERNAME_UNEXISTED;  //用户不存在
        }
        else if(user_r.getPwd().equals(user.getPwd())){
            loginResultEnum = LoginResultEnum.SUCCESS;       //密码正确
        }
        else {
            loginResultEnum = LoginResultEnum.PASSWORD_ERROR;      //密码错误
        }
        return loginResultEnum;
    }
}
