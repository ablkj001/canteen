package com.cuit.controller;

import com.cuit.pojo.Room;
import com.cuit.pojo.User;
import com.cuit.service.Impl.UserServiceImpl;
import com.cuit.service.RoomService;
import com.cuit.service.UserService;
import com.cuit.util.LoginResultEnum;
import com.cuit.util.RegisterResultEnum;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    //用户登录
    @RequestMapping("/user/login")
    @ResponseBody
    public JSONObject Login(@RequestBody Map map,HttpSession session){
        JSONObject loginResult = new JSONObject();
        String uname = map.get("username").toString();
        String pwd = map.get("password").toString();
        System.out.println("进入！");
        User user = new User(uname,pwd);
        LoginResultEnum loginResultEnum = userService.checkLogin(user);
        if (loginResultEnum.equals(LoginResultEnum.USERNAME_UNEXISTED)){
            loginResult.put("message","用户名不存在");
            loginResult.put("code",1);
            return loginResult;
        }else if(loginResultEnum.equals(LoginResultEnum.FROZEN_ACCOUNT)){
            loginResult.put("message","账号被冻结！");
            loginResult.put("code",1);
        } else if(loginResultEnum.equals(LoginResultEnum.PASSWORD_ERROR)){
            loginResult.put("message","密码错误");
            loginResult.put("code",1);
        }else {
            loginResult.put("message","登录成功");
            loginResult.put("code",0);
            loginResult.put("token",uname);
            session.setAttribute("loginuser",uname);
        }
        return loginResult;
    }

    //返回用户信息
    @RequestMapping("/user/info")
    @ResponseBody
    public JSONObject getUser(@RequestHeader("Authorization") String token){
        User user = userService.queryUserByUame(token);
        JSONObject get = new JSONObject();
        get.put("data",user);
        get.put("code",0);
        return get;
    }

    //普通用户注册
    @RequestMapping("/user/regist")
    @ResponseBody
    public JSONObject UserRegist(@RequestBody Map map){
        JSONObject registResult = new JSONObject();
        String uname = map.get("username").toString();
        String pwd = map.get("password").toString();
        String tel = map.get("tel").toString();
        String flag = map.get("usertype").toString();
        User user = new User(uname,pwd,tel,flag);
        RegisterResultEnum resultEnum = userService.add(user);
        if (resultEnum.equals(RegisterResultEnum.USERNAME_DUPLICATED)){
            registResult.put("message","用户名已存在！");
            registResult.put("code",1);
            return registResult;
        }else {
            registResult.put("message","注册成功！");
            registResult.put("code",0);
            return registResult;
        }
    }

    //返回食堂列表
    @RequestMapping("/manager/roomlist")
    @ResponseBody
    public JSONObject roomList(){
        JSONObject json = new JSONObject();
        List<Room> rooms = roomService.queryRoomList();
        json.put("data",rooms);
        json.put("code",0);
        return json;
    }

    //店铺注册
}
