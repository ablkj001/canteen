package com.cuit.controller;

import com.cuit.combine.CP;
import com.cuit.combine.DS;
import com.cuit.combine.SD;
import com.cuit.pojo.Comment;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.Shop;
import com.cuit.pojo.US;
import com.cuit.service.*;
import jdk.nashorn.internal.scripts.JO;
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

    @Autowired
    private UserService userService;

    @Autowired
    private USService usService;

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
            DS ds = new DS(dishes.getDid(), dishes.getDname(), dishes.getDprice(), dishes.getDimage(), dishes.getSid(), shop.getSname(), dishes.getDetail(), dishes.getStatus());
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
            List<Comment> comments = commentService.queryCommentByPage(page, did);
            for (Comment comment : comments){
                Integer uid = comment.getUid();
                String uname = userService.queryUserById(uid).getUname();
                comment.setUname(uname);
            }
            Integer i = commentService.CountCommentsByDid(did);
            CP cp = new CP(i, comments);
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
            json.put("data", dishes);
            json.put("code", 0);
        }
        return json;
    }

    //分页获取店铺菜品列表,7个为一页
    @RequestMapping("/dishes/page")
    @ResponseBody
    public JSONObject getDishesByPage(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer uid = userService.queryUserByUame(token).getUid();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            Integer pagesize = Integer.parseInt(map.get("pagesize").toString());
            US us = usService.queryUS(uid);
            Integer sid = us.getSid();
            Integer count = dishesService.countDishes(sid);
            List<Dishes> dishes = dishesService.queryDishesByPage(page, sid, pagesize);
            json.put("data", dishes);
            json.put("count", count);
            json.put("code", 0);
        }
        return json;
    }

    //根据菜品名查询菜品
    @RequestMapping("/dishes/query")
    @ResponseBody
    public JSONObject queryDishesByName(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            String dname = map.get("keyWord").toString();
            Integer uid = userService.queryUserByUame(token).getUid();
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            US us = usService.queryUS(uid);
            Integer sid = us.getSid();
            List<Dishes> dishes = dishesService.queryDishesByDname(dname, sid, page);
            Integer count = dishesService.countDishesByDname(dname, sid);
            json.put("count", count);
            json.put("data", dishes);
            json.put("code", 0);
        }
        return json;
    }

    //改变菜品的状态
    @RequestMapping("/dishes/status")
    @ResponseBody
    public JSONObject changeDishesStatus(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("did").toString());
            Integer status = Integer.parseInt(map.get("status").toString());
            Integer i = dishesService.changeDishesStatus(did, status);
            json.put("data", i);
            json.put("code", 0);
        }
        return json;
    }

    //新增菜品
    @RequestMapping("/dishes/add")
    @ResponseBody
    public JSONObject addDishes(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            String dimage;
            String swiper;
            if(map.get("dimage") == null){
                dimage = "";
            }else {
                dimage = map.get("dimage").toString();
            }
            if(map.get("swiper") == null){
                swiper = "";
            }else {
                swiper = map.get("swiper").toString();
            }
            String dname = map.get("dname").toString();
            Integer dprice = Integer.parseInt(map.get("dprice").toString());
            String detail = map.get("detail").toString();
            Integer uid = userService.queryUserByUame(token).getUid();
            US us = usService.queryUS(uid);
            Integer sid = us.getSid();
            Dishes dishes = new Dishes(dname, dprice, dimage, sid, detail, swiper);
            if (dishesService.checkDishes(dname, sid) != null) {
                json.put("message", "该菜品已经存在！请勿重复添加！");
                json.put("code", 1);
            } else {
                Integer i = dishesService.addDishes(dishes);
                json.put("data", i);
                json.put("code", 0);
            }
        }
        return json;
    }

    //编辑菜品
    @RequestMapping("/dishes/edit")
    @ResponseBody
    public JSONObject editDishes(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("message", "请先登录！");
            json.put("code", 1);
        } else {
            String dimage;
            String swiper;
            if(map.get("dimage") == null){
                dimage = "";
            }else {
                dimage = map.get("dimage").toString();
            }
            if(map.get("swiper") == null){
                swiper = "";
            }else {
                swiper = map.get("swiper").toString();
            }
            Integer did = Integer.parseInt(map.get("did").toString());
            String dname = map.get("dname").toString();
            Integer dprice = Integer.parseInt(map.get("dprice").toString());
            Integer sid = Integer.parseInt(map.get("sid").toString());
            String detail = map.get("detail").toString();
            Integer status = Integer.parseInt(map.get("status").toString());
            Integer dishelevel = Integer.parseInt(map.get("dishelevel").toString());
            Integer swiperlevel = Integer.parseInt(map.get("swiperlevel").toString());
            Dishes dishes = new Dishes(did, dname, dprice, dimage, sid, detail, status, swiper, dishelevel, swiperlevel);
            dishesService.editDishes(dishes);
            json.put("message", "修改成功");
            json.put("code", 0);
        }
        return json;
    }
}
