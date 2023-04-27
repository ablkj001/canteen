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
    public JSONObject getRoom(@RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if(token == null){
            json.put("data",null);
            json.put("code",1);
        }else {
            List<Room> rooms = roomService.queryRoomList();
            //食堂名字->店铺名字
            List<RS> list = new ArrayList<>();
            for(Room room:rooms){
                List<Shop> shop = shopService.queryShopByRid(room.getRid());
                RS rs = new RS(room,shop);
                list.add(rs);
            }
            System.out.println(list);
            json.put("data",list);
            json.put("code",0);
        }
        return json;
    }

    //食堂管理者添加食堂
    @RequestMapping("/room/add")
    @ResponseBody
    public JSONObject addRoom(@RequestBody Map map){
        JSONObject addRoom = new JSONObject();
        String rname = map.get("rname").toString();
        Room room = new Room(rname,new Date());
        Integer i =roomService.insertRoom(room);
        addRoom.put("message","添加成功！");
        return addRoom;
    }

    //食堂管理者移除食堂
    @RequestMapping("/room/delete")
    @ResponseBody
    public JSONObject deleteRoom(@RequestBody Map map){
        JSONObject deleteRoom = new JSONObject();
        Integer rid = Integer.parseInt(map.get("rid").toString());
        Integer i = roomService.deleteRoom(rid);
        deleteRoom.put("message","删除成功！");
        return deleteRoom;
    }
}
