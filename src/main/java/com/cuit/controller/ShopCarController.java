package com.cuit.controller;

import com.cuit.combine.SC;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.ShopCar;
import com.cuit.pojo.User;
import com.cuit.service.DishesService;
import com.cuit.service.ShopCarService;
import com.cuit.service.ShopService;
import com.cuit.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private DishesService dishesService;

    @RequestMapping("/shopcar/add")
    @ResponseBody
    public JSONObject addShopCar(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer did = Integer.parseInt(map.get("did").toString());
            Integer sid = Integer.parseInt(map.get("sid").toString());
            Integer count = Integer.parseInt(map.get("count").toString());
            ShopCar shopCar = new ShopCar(uid, did, sid, count);
            Integer i = shopCarService.addShopCar(shopCar);
            if(i == 0){
                json.put("message","超过购买限度！");
                json.put("code",2);
            }else {
                json.put("message", "添加成功！");
                json.put("code", 0);
            }
        }
        return json;
    }

    @RequestMapping("/shopcar/update")
    @ResponseBody
    public JSONObject updateShopCar(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer did = Integer.parseInt(map.get("did").toString());
            Integer sid = Integer.parseInt(map.get("sid").toString());
            Integer count = Integer.parseInt(map.get("count").toString());
            ShopCar shopCar = new ShopCar(uid, did, sid, count);
            Integer i = shopCarService.updateShopCar(shopCar);
            if(i == 0){
                json.put("message","超过购买限度！");
                json.put("code",2);
            }else {
                json.put("message", "修改成功！");
                json.put("code", 0);
            }
        }
        return json;
    }

    @RequestMapping("/shopcar/delete")
    @ResponseBody
    public JSONObject deleteShopCar(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            Integer carid = Integer.parseInt(map.get("carid").toString());
            Integer i = shopCarService.deleteShopCar(carid);
            json.put("message", "删除成功！");
            json.put("code", 0);
        }
        return json;
    }

    @RequestMapping("/shopcar/list")
    @ResponseBody
    public JSONObject queryShopCarByUid(@RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            List<ShopCar> shopCars = shopCarService.queryShopcarByUid(uid);
            List<SC> scs = new ArrayList<>();
            for (ShopCar shopCar : shopCars){
                String sname = shopService.queryShopBySid(shopCar.getSid()).getSname();
                Dishes dishes = dishesService.queryDishesByDid(shopCar.getDid());
                String dname = dishes.getDname();
                String dimage = dishes.getDimage();
                Integer dprice = dishes.getDprice();
                Integer dstatus = dishes.getStatus();
                Integer count = shopCar.getCount();
                Integer status = shopCar.getStatus();
                SC sc = new SC(sname,dname,dimage,dprice,dstatus,count,status);
                scs.add(sc);
            }
            json.put("data", scs);
            json.put("code", 0);
        }
        return json;
    }

    @RequestMapping("/shopcar/select")
    @ResponseBody
    public JSONObject selectShopCar(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            Integer did = Integer.parseInt(map.get("did").toString());
            Integer sid = Integer.parseInt(map.get("sid").toString());
            ShopCar shopCar = new ShopCar(uid, did, sid);
            Integer i = shopCarService.addShopCar(shopCar);
            json.put("message", "勾选成功！");
            json.put("code", 0);
        }
        return json;
    }
}