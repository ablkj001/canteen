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
    public JSONObject getShopsByRid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer sid = Integer.parseInt(map.get("sid").toString());
            Shop shop = shopService.queryShopBySid(sid);
            List<Dishes> dishes = dishesService.queryDishesByStatus(sid);
            SD sd = new SD(shop, dishes);
            System.out.println(sd);
            json.put("data", sd);
            json.put("code", 0);
        }
        return json;
    }

    //根据店铺ID或店铺名查询店铺
    @RequestMapping("/shop/query")
    @ResponseBody
    public JSONObject queryShopBySnameOrSid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            if (map.get("sid") == null) {
                Integer sid = 0;
            }
            if (map.get("sname") == null) {
                String sname = "";
            }
            Integer sid = Integer.parseInt(map.get("sid").toString());
            String sname = map.get("sname").toString();
            Integer page = Integer.parseInt(map.get("page").toString());
            List<Shop> shops = shopService.queryShopBySnameOrSid(sid, sname, page);
            json.put("data", shops);
            json.put("code", 0);
        }
        return json;
    }

    //编辑店铺信息
    @RequestMapping("/shop/edit")
    @ResponseBody
    public JSONObject editShop(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer sid = Integer.parseInt(map.get("sid").toString());
            String sname = map.get("sname").toString();
            Integer rid = Integer.parseInt(map.get("rid").toString());
            String location = map.get("location").toString();
            String manager = map.get("manager").toString();
            String tel = map.get("tel").toString();
            Integer status = Integer.parseInt(map.get("status").toString());
            Shop shop = new Shop(sid, sname, rid, location, manager, tel, status);
            Integer i = shopService.editShop(shop);
            json.put("data", i);
            json.put("code", 0);
        }
        return json;
    }

    //分页展示所有店铺列表
    @RequestMapping("/shop/manager")
    @ResponseBody
    public JSONObject shopList(@RequestBody Map map, @RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer page = Integer.parseInt(map.get("page").toString());
            List<Shop> shops = shopService.queryShopByPage(page);
            Integer count = shopService.countShop();
            json.put("count",count);
            json.put("data",shops);
            json.put("code",0);
        }
        return json;
    }
}
