package com.cuit.controller;

import com.cuit.combine.OR;
import com.cuit.pojo.User;
import com.cuit.service.OrderService;
import com.cuit.service.USService;
import com.cuit.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private USService usService;

    //店铺改变订单状态
    @RequestMapping("/order/status")
    @ResponseBody
    public JSONObject changeStatus(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("did").toString());
            String orderid = map.get("orderid").toString();
            Integer i = orderService.changeOrderStatus(did,orderid);
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }

    //购物车结算功能
    @RequestMapping("/order/shopcar")
    @ResponseBody
    public JSONObject orderShopcar(@RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer i = orderService.addOrder(user.getUid());
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }

    //菜品界面支付生成订单功能
    @RequestMapping("/order/dishes")
    @ResponseBody
    public JSONObject orderDishes(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer sid = Integer.parseInt(map.get("sid").toString());
            Integer did = Integer.parseInt(map.get("did").toString());
            Integer count = Integer.parseInt(map.get("count").toString());
            Integer i = orderService.insertOrder(uid,sid,did,count);
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }

    //用户端显示订单界面
    @RequestMapping("/order/userlist")
    @ResponseBody
    public JSONObject userList(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            Integer pagesize = Integer.parseInt(map.get("pagesize").toString());
            Integer isdone = Integer.parseInt(map.get("isdone").toString());
            List<OR> ors = orderService.queryOrderByUid(uid,page,pagesize,isdone);
            Integer count = orderService.countOrderByUid(uid,isdone);
            json.put("count",count);
            json.put("data",ors);
            json.put("code",0);
        }
        return json;
    }

    //店铺端显示订单界面
    @RequestMapping("/order/shoplist")
    @ResponseBody
    public JSONObject shopList(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer sid = usService.queryUS(uid).getSid();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            Integer pagesize = Integer.parseInt(map.get("pagesize").toString());
            Integer isdone = Integer.parseInt(map.get("isdone").toString());
            List<OR> ors = orderService.queryOrderBySid(sid,page,pagesize,isdone);
            Integer count = orderService.countOrderBySid(sid,isdone);
            json.put("count",count);
            json.put("data",ors);
            json.put("code",0);
        }
        return json;
    }
}
