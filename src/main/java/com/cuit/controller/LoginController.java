package com.cuit.controller;

import cn.hutool.json.JSON;
import com.cuit.pojo.Room;
import com.cuit.pojo.Shop;
import com.cuit.pojo.User;
import com.cuit.service.RoomService;
import com.cuit.service.ShopService;
import com.cuit.service.USService;
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

    @Autowired
    private ShopService shopService;

    @Autowired
    private USService usService;

    //用户登录
    @RequestMapping("/user/login")
    @ResponseBody
    public JSONObject Login(@RequestBody Map map){
        JSONObject loginResult = new JSONObject();
        String uname = map.get("username").toString();
        String pwd = map.get("password").toString();
        String flag = map.get("flag").toString();
        User user = new User(uname,pwd,flag);
        LoginResultEnum loginResultEnum = userService.checkLogin(user);
        if (loginResultEnum.equals(LoginResultEnum.USERNAME_UNEXISTED)){
            loginResult.put("message","用户名不存在");
            loginResult.put("code",1);
            return loginResult;
        }else if(loginResultEnum.equals(LoginResultEnum.USER_BEEN_DELETED)){
            loginResult.put("message","用户已被删除！");
            loginResult.put("code",1);
        } else if(loginResultEnum.equals(LoginResultEnum.PERMISSION_NOT_MATCH)){
            loginResult.put("message","权限不正确！");
            loginResult.put("code",1);
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

    //编辑用户联系方式
    @RequestMapping("/user/editTel")
    @ResponseBody
    public JSONObject editUserTel(@RequestHeader("Authorization") String token,@RequestBody Map map){
        JSONObject json = new JSONObject();
        if(token == null){
            json.put("message","请先登录!");
            json.put("code",1);
        }else{
            Integer uid = Integer.parseInt(map.get("uid").toString());
            //根据uid获取用户信息
            User user = userService.queryUserById(uid);
            String tel = map.get("tel").toString();
            user.setTel(tel);
            Integer i = userService.updateUser(user);
            json.put("message","修改成功！");
            json.put("code",0);
        }
        return json;
    }

    //编辑用户头像
    @RequestMapping("/user/editAvatar")
    @ResponseBody
    public JSONObject editUserAvatar(@RequestHeader("Authorization") String token,@RequestBody Map map){
        JSONObject json = new JSONObject();
        if(token == null){
            json.put("message","请先登录!");
            json.put("code",1);
        }else{
            Integer uid = Integer.parseInt(map.get("uid").toString());
            //根据uid获取用户信息
            User user = userService.queryUserById(uid);
            String uavatar = map.get("uavatar").toString();
            user.setUavatar(uavatar);
            Integer i = userService.updateUser(user);
            json.put("message","修改成功！");
            json.put("code",0);
        }
        return json;
    }

    //编辑用户密码
    @RequestMapping("/user/editPwd")
    @ResponseBody
    public JSONObject editUserPwd(@RequestHeader("Authorization") String token,@RequestBody Map map){
        JSONObject json = new JSONObject();
        if(token == null){
            json.put("message","请先登录!");
            json.put("code",1);
        }else{
            Integer uid = Integer.parseInt(map.get("uid").toString());
            //根据uid获取用户信息
            User user = userService.queryUserById(uid);
            String pwd = map.get("pwd").toString();
            user.setPwd(pwd);
            Integer i = userService.updateUser(user);
            json.put("message","修改成功！");
            json.put("code",0);
        }
        return json;
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
    @RequestMapping("/manager/regist")
    @ResponseBody
    public JSONObject managerRegist(@RequestBody Map map){
        JSONObject json = new JSONObject();
        //用户个人信息部分
        String uname = map.get("username").toString();
        String pwd = map.get("password").toString();
        String tel = map.get("tel").toString();
        String flag = map.get("usertype").toString();
        User user = new User(uname,pwd,tel,flag);
        //店铺信息部分
        String sname = map.get("sname").toString();
        Integer rid = Integer.parseInt(map.get("rid").toString());
        String location = map.get("location").toString();
        Shop shop = new Shop(sname,rid,location,uname,tel);
        RegisterResultEnum userresultEnum = userService.add(user);
        RegisterResultEnum shopresultEnum = shopService.addShop(shop);
        if (userresultEnum.equals(RegisterResultEnum.USERNAME_DUPLICATED)){
            json.put("message","用户名已存在！");
            json.put("code",1);
            return json;
        }else if(shopresultEnum.equals(RegisterResultEnum.SHOPNAME_DUPLICATED)){
            json.put("message","该店铺已在当前食堂注册！");
            json.put("code",2);
            return json;
        }else {
            //店铺与管理员关联表
            Integer uid = userService.queryUserByUame(uname).getUid();
            Integer sid = shopService.queryShopBySname(sname).getSid();
            Integer j = usService.addService(uid,sid);
            json.put("message","注册成功！");
            json.put("code",0);
            return json;
        }
    }
}
