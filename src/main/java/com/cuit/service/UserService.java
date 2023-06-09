package com.cuit.service;

import com.cuit.pojo.User;
import com.cuit.util.LoginResultEnum;
import com.cuit.util.RegisterResultEnum;

import java.util.List;

public interface UserService {

    //查询所有用户列表
    List<User> queryUserList();

    //通过用户id查询用户
    User queryUserById(Integer uid);

    //编辑用户信息
    Integer updateUser(User user);

    //管理者删除用户？
    Integer deleteUser(Integer Uid);

    //通过用户名获取用户
    User queryUserByUame(String uname);

    //用户登录
    LoginResultEnum checkLogin(User user);

    //用户注册
    RegisterResultEnum add(User user);

    //根据用户名或用户ID查询用户
    List<User> queryUserByUnameOrUid(String keyword,Integer page);

    //分页获取用户列表
    List<User> queryUserByPage(Integer page);

    //统计用户的数量
    Integer countUser();

    //改变用户的状态
    Integer changeUserStatus(Integer uid,Integer status);

    //统计查询后用户的数量
    Integer countQureyUser(String keyword,Integer page);
}
