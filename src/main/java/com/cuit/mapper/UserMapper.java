package com.cuit.mapper;

import com.cuit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这个是一个mybatis的类
@Mapper
@Repository
public interface UserMapper {

    //获取所有用户
    List<User> queryUserList();

    //通过uid获取用户
    User queryUserById(@Param("uid") Integer uid);

    //通过用户名获取用户
    User queryUserByUname(@Param("uname") String uname);

    //添加用户
    Integer addUser(@Param("uname") String uname,@Param("pwd") String pwd,@Param("flag") String flag,@Param("tel") String tel);

    //更新用户
    Integer updateUser(User user);

    //删除用户
    Integer deleteUser(Integer uid);
}
