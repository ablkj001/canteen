package com.cuit.controller;

import com.cuit.combine.RS;
import com.cuit.pojo.Room;
import com.cuit.pojo.Shop;
import com.cuit.service.DishesService;
import com.cuit.service.RoomService;
import com.cuit.service.ShopService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private DishesService dishesService;

    //用户首页食堂的列表
    @RequestMapping("/room/list")
    @ResponseBody
    public JSONObject getRoom(@RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            List<Room> rooms = roomService.queryRoomList();
            //食堂名字->店铺名字
            List<RS> list = new ArrayList<>();
            for (Room room : rooms) {
                List<Shop> shop = shopService.queryShopByRid(room.getRid());
                RS rs = new RS(room, shop);
                rs.check();
                list.add(rs);
            }
            System.out.println(list);
            json.put("data", list);
            json.put("code", 0);
        }
        return json;
    }

    //管理员分页获取食堂
    @RequestMapping("/room/mlist")
    @ResponseBody
    public JSONObject managerRoom(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<Room> rooms = roomService.queryRoomByPage(page);
            Integer count = roomService.countRoom();
            json.put("data", rooms);
            json.put("code", 0);
            json.put("count", count);
        }
        return json;
    }

    //管理员根据食堂ID或食堂名称查找食堂
    @RequestMapping("/room/query")
    @ResponseBody
    public JSONObject queryRoom(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            String keyword = map.get("keyword").toString();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<Room> rooms = roomService.queryRoomByRidOrRname(keyword, page);
            Integer count = roomService.countQueryRoom(keyword,page);
            json.put("count",count);
            json.put("data",rooms);
            json.put("code", 0);
        }
        return json;
    }

    //编辑食堂信息
    @RequestMapping("/room/edit")
    @ResponseBody
    public JSONObject editRoom(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer rid = Integer.parseInt(map.get("rid").toString());
            String rname = map.get("rname").toString();
            String tel = map.get("tel").toString();
            Room room = roomService.queryRoomByRid(rid);
            room.setRname(rname);
            room.setTel(tel);
            Integer i = roomService.editRoom(room);
            json.put("data", i);
            json.put("code", 0);
        }
        return json;
    }

    //添加新的食堂
    @RequestMapping("/room/add")
    @ResponseBody
    public JSONObject addRoom(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            String rname = map.get("rname").toString();
            String tel = map.get("tel").toString();
            Room room = new Room(rname,new Date(),tel);
            Integer i = roomService.insertRoom(room);
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }

    //改变食堂的状态，即解散食堂
    @RequestMapping("/room/status")
    @ResponseBody
    public JSONObject roomStatus(@RequestHeader("Authorization") String token, @RequestBody Map map){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer rid = Integer.parseInt(map.get("rid").toString());
            //获取食堂当前的状态
            Integer status = Integer.parseInt(map.get("status").toString());
            //根据食堂ID获取它所属的店铺列表，再将食堂所属店铺的菜品状态全部置为下架
            List<Shop> shops = shopService.queryShopByRid(rid);
            for(Shop shop:shops){
                //改变每一个菜品的状态，将菜品全部置为删除状态
                dishesService.changeStatusBySid(shop.getSid());
            }
            Integer count = shopService.changeShopStatus(rid);
            Integer i = roomService.roomStatus(rid,status);
            json.put("count",count);
            json.put("data",i);
            json.put("code",0);
        }
        return json;
    }
}
