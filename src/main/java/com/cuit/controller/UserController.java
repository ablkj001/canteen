package com.cuit.controller;

import com.cuit.pojo.User;
import com.cuit.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.server.UID;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //根据用户名或用户ID查询用户
    @RequestMapping("/user/queryNameOrId")
    @ResponseBody
    public JSONObject queryUser(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            String keyword = map.get("keyword").toString();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<User> users = userService.queryUserByUnameOrUid(keyword,page);
            Integer count = userService.countQureyUser(keyword,page);
            json.put("count",count);
            json.put("data", users);
            json.put("code", 0);
        }
        return json;
    }

    //获取用户列表
    @RequestMapping("/user/queryByPage")
    @ResponseBody
    public JSONObject getUserList(@RequestBody Map map, @RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            Integer count = userService.countUser();
            List<User> users = userService.queryUserByPage(page);
            json.put("data",users);
            json.put("count",count);
            json.put("code",0);
        }
        return json;
    }

    //改变用户的状态
    @RequestMapping("/user/changeUserStatus")
    @ResponseBody
    public JSONObject changeUserStatus(@RequestBody Map map, @RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer status = Integer.parseInt(map.get("status").toString());
            Integer uid = Integer.parseInt(map.get("uid").toString());
            Integer i = userService.changeUserStatus(uid,status);
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }
}
