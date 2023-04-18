package com.cuit;

import com.cuit.pojo.User;
import com.cuit.service.Impl.UserServiceImpl;
import com.cuit.util.LoginResultEnum;
import com.cuit.util.RegisterResultEnum;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //按照指定方法运行
public class UserTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserServiceImpl userService;

    @Test
    void test0() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){
        List<User> users = userService.queryUserList();
    }

    @Test
    public void  testB(){
        User user = userService.queryUserByUame("test");
    }

    @Test
    public void testC(){
        User user = userService.queryUserById(2);
    }

    @Test
    public  void testG(){
        User user = new User("王亦","123");
        LoginResultEnum loginResultEnum = userService.checkLogin(user);
        System.out.println(loginResultEnum);
    }
}
