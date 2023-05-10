package com.cuit.controller;

import com.cuit.combine.SD;
import com.cuit.pojo.*;
import com.cuit.service.*;
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

    @Autowired
    private DRecordService dRecordService;

    @Autowired
    private UserService userService;

    @Autowired
    private USService usService;

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
            String keyword = map.get("keyword").toString();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<Shop> shops = shopService.queryShopBySnameOrSid(keyword, page);
            Integer count = shopService.countQueryShop(keyword);
            json.put("count", count);
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
            if(status == 2){
                US us = usService.queryUSBySid(sid);
                json.put("info",us.getUid());
            }
            //首先应获取原店铺的状态
            Shop shop = shopService.queryShopBySid(sid);
            //count用于计算改变的数据条数
            Integer count = 0;
            //如果一开始是营业状态
            if (shop.getStatus() == 0) {
                //若状态为1，则为停业整顿状态，将相应店铺下的菜品插入到数据库的关联表中
                //若状态为2，则将所有菜品数据全部都置为下架状态
                if (status == 1) {
                    //首先查询出当前店铺下所有未被下架的菜品
                    List<Dishes> dishes = dishesService.queryDishesByStatus(sid);
                    //循环遍历店铺菜品的列表,往关系表中添加
                    for (Dishes dishes1 : dishes) {
                        DRecord dRecord = new DRecord(dishes1.getDid(), dishes1.getSid());
                        Integer i = dRecordService.addRecord(dRecord);
                        count = count + i;
                    }
                    //再将当前店铺中的菜品均置为下架状态
                    Integer i = dishesService.changeStatusBySid(sid);
                } else if (status == 2) {
                    //将当前店铺中的菜品置为下架状态
                    Integer i = dishesService.changeStatusBySid(sid);
                    count = count + i;
                }
            } else {
                //若状态为0则将记录表中上架的菜品赋值到菜品表中
                //若状态为2则将当前店铺的所有菜品状态置为0并将关系表中与当前店铺有关的菜品删除
                if (status == 0) {
                    //从关系表中查询当前店铺的数据
                    List<DRecord> dRecords = dRecordService.queryDrecord(sid);
                    //遍历关系，将当前店铺的状态复原，将菜品置为上架状态
                    for (DRecord dRecord : dRecords) {
                        Integer i = dishesService.changeDishesStatus(dRecord.getDid(), 0);
                        count = count + i;
                    }
                } else if (status == 2) {
                    //将当前店铺中的菜品全部置为下架状态
                    //在关系表中删除当前店铺的关系
                    Integer i = dishesService.changeStatusBySid(sid);
                    //记录当前修改数据的条数
                    count = count + i;
                    //从关系表中删除相应关系
                    dRecordService.deleteRecord(sid);
                }
            }
            Shop shop1 = new Shop(sid, sname, rid, location, manager, tel, status);
            //店铺修改,返回修改的条数
            Integer i = shopService.editShop(shop1);
            json.put("count", count);
            json.put("data", i);
            json.put("code", 0);
        }
        return json;
    }

    //分页展示所有店铺列表，包括正常营业，停业整顿,status分别为0和1
    @RequestMapping("/shop/manager")
    @ResponseBody
    public JSONObject shopList(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<Shop> shops = shopService.queryShopByPage(page);
            Integer count = shopService.countShop();
            json.put("count", count);
            json.put("data", shops);
            json.put("code", 0);
        }
        return json;
    }

    //返回当前店铺的信息
    @RequestMapping("/shop/info")
    @ResponseBody
    public JSONObject shopInfo(@RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            User user = userService.queryUserByUame(token);
            US us = usService.queryUS(user.getUid());
            Integer sid = us.getSid();
            Shop shop = shopService.queryShopBySid(sid);
            json.put("data", shop);
            json.put("code", 0);
        }
        return json;
    }
}
