package com.cuit.controller;

import com.cuit.combine.RS;
import com.cuit.pojo.Room;
import com.cuit.pojo.Shop;
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
            Integer page = Integer.parseInt(map.get("page").toString());
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
            String rname;
            Integer rid;
            Integer page = Integer.parseInt(map.get("page").toString());
            if (map.get("rname") == null) {
                rname = "";
            } else {
                rname = map.get("rname").toString();
            }
            if (map.get("rid") == null) {
                rid = 0;
            } else {
                rid = Integer.parseInt(map.get("rid").toString());
            }
            List<Room> rooms = roomService.queryRoomByRidOrRname(rid, rname, page);
        }
        return json;
    }

    //编辑食堂名称
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
            Room room = roomService.queryRoomByRid(rid);
            room.setRname(rname);
            Integer i = roomService.editRoom(room);
            json.put("data", i);
            json.put("code", 0);
        }
        return json;
    }
}
