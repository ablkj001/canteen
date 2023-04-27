package com.cuit.controller;

import com.cuit.combine.SD;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.Room;
import com.cuit.pojo.Shop;
import com.cuit.service.DishesService;
import com.cuit.service.ShopService;
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
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private DishesService dishesService;

    //返回食堂中店铺列表
    @RequestMapping("/shop/list")
    @ResponseBody
    public JSONObject getShopsByRid(@RequestBody Map map,@RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if(token == null){
            json.put("data",null);
            json.put("code",1);
        }else{
            Integer sid = Integer.parseInt(map.get("sid").toString());
            Shop shop = shopService.queryShopBySid(sid);
            List<Dishes> dishes = dishesService.queryDishesByStatus(sid);
            SD sd = new SD(shop,dishes);
            System.out.println(sd);
            json.put("data",sd);
            json.put("code",0);
        }
        return json;
    }

    //食堂管理者添加店铺
    @RequestMapping("/shop/add")
    public JSONObject addShop(@RequestBody Map map){
        JSONObject add = new JSONObject();
        String sname = map.get("sname").toString();
        Integer rid = Integer.parseInt(map.get("rid").toString());
        String location = map.get("location").toString();
        String manager = map.get("manager").toString();
        String tel = map.get("tel").toString();
        Shop shop = new Shop(sname,rid,location,manager,tel);
        Integer i = shopService.addShop(shop);
        add.put("message","添加成功");
        return add;
    }
}
