package com.cuit.controller;

import com.cuit.combine.CP;
import com.cuit.combine.DS;
import com.cuit.combine.SD;
import com.cuit.pojo.Comment;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.Shop;
import com.cuit.service.CommentService;
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
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ShopService shopService;

    //显示菜品列表
    @RequestMapping("/dishes")
    @ResponseBody
    public JSONObject getDishesByDid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("foodID").toString());
            Dishes dishes = dishesService.queryDishesByDid(did);
            Shop shop = shopService.queryShopBySid(dishes.getSid());
            DS ds = new DS(dishes.getDid(),dishes.getDname(),dishes.getDprice(),dishes.getDimage(),dishes.getSid(),shop.getSname(),dishes.getDetail(),dishes.getStatus());
            json.put("data", ds);
            json.put("code", 0);
        }
        return json;
    }

    //显示当前菜品下相应的评论
    @RequestMapping("/dishes/comment")
    @ResponseBody
    public JSONObject getCommentByDid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("foodID").toString());
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            List<Comment> comments = commentService.queryCommentByPage(page,did);
            Integer i = commentService.CountCommentsByDid(did);
            CP cp = new CP(i,comments);
            json.put("data", cp);
            json.put("code", 0);
        }
        return json;
    }

    //根据随机数生成首页的七张推介菜品
    @RequestMapping("/dishes/random")
    @ResponseBody
    public JSONObject getRandomDishes(@RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            List<Dishes> dishes = dishesService.queryRandomDished();
            json.put("data",dishes);
            json.put("code",0);
        }
        return json;
    }
}
