package com.cuit.service.Impl;

import com.cuit.mapper.UserMapper;
import com.cuit.pojo.User;
import com.cuit.service.UserService;
import com.cuit.util.LoginResultEnum;
import com.cuit.util.RegisterResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    LoginResultEnum loginResultEnum = null;

    RegisterResultEnum registerResultEnum =null;

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
        } else if(user_r.getStatus() == 1){
            loginResultEnum = LoginResultEnum.FROZEN_ACCOUNT;   //用户被冻结
        } else if(user_r.getStatus() == 2){
            loginResultEnum = LoginResultEnum.USER_BEEN_DELETED;    //用户已被删除
        } else if(!user.getFlag().equals(user_r.getFlag())) {
            loginResultEnum = LoginResultEnum.PERMISSION_NOT_MATCH; //错误权限的人登录错误权限的系统
        } else if(user_r.getPwd().equals(user.getPwd()) && user.getFlag().equals(user_r.getFlag())){
            loginResultEnum = LoginResultEnum.SUCCESS;       //密码且权限正确
        } else {
            loginResultEnum = LoginResultEnum.PASSWORD_ERROR;      //密码错误
        }
        return loginResultEnum;
    }

    @Override
    public RegisterResultEnum add(User user) {
        if(userMapper.queryUserByUname(user.getUname())!=null){
            registerResultEnum = RegisterResultEnum.USERNAME_DUPLICATED; //用户名存在
        }
        else {
            userMapper.addUser(user.getUname(),user.getPwd(),user.getTel(),user.getFlag());
            registerResultEnum = RegisterResultEnum.SUCCESS;        //注册成功
        }
        return registerResultEnum;
    }

    @Override
    public List<User> queryUserByUnameOrUid(String keyword,Integer page) {
        List<User> users = userMapper.queryUserByUnameOrId(keyword,page);
        return users;
    }

    @Override
    public List<User> queryUserByPage(Integer page) {
        List<User> users = userMapper.queryUserListByPage(page);
        return users;
    }

    @Override
    public Integer countUser() {
        Integer count = userMapper.countUser();
        return count;
    }

    @Override
    public Integer changeUserStatus(Integer uid, Integer status) {
        Integer i = userMapper.chageUserStatus(uid,status);
        return i;
    }

    @Override
    public Integer countQureyUser(String keyword, Integer page) {
        Integer count = userMapper.countUserByUnameOrId(keyword,page);
        return count;
    }
}
