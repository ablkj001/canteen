package com.cuit.controller;

import com.cuit.pojo.User;
import com.cuit.service.Impl.UserServiceImpl;
import com.cuit.util.LoginResultEnum;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user/login")
    @ResponseBody
    public JSONObject Login(@RequestBody Map map,HttpSession session){
        JSONObject loginResult = new JSONObject();
        String uname = map.get("uname").toString();
        String pwd = map.get("pwd").toString();
        System.out.println("进入！");
        User user = new User(uname,pwd);
        LoginResultEnum loginResultEnum = userService.checkLogin(user);
        if (loginResultEnum.equals(LoginResultEnum.USERNAME_UNEXISTED)){
            loginResult.put("msg","用户名不存在");
            return loginResult;
        }else if(loginResultEnum.equals(LoginResultEnum.PASSWORD_ERROR)){
            loginResult.put("msg","密码错误");
        }else {
            loginResult.put("msg","登录成功");
            session.setAttribute("loginuser",uname);
        }
        return loginResult;
    }

    @RequestMapping("/user/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("loginuser");
        session.removeAttribute("mangeruser");
        return "redirect:/index";
    }
}
