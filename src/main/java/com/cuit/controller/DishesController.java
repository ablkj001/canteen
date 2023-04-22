package com.cuit.controller;

import com.cuit.combine.SD;
import com.cuit.pojo.Comment;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.Shop;
import com.cuit.service.CommentService;
import com.cuit.service.DishesService;
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

    @RequestMapping("/dishes")
    @ResponseBody
    public JSONObject getDishesByDid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("did").toString());
            Dishes dishes = dishesService.queryDishesByDid(did);
            json.put("data", dishes);
            json.put("code", 0);
        }
        return json;
    }

    @RequestMapping("/dishes/comment")
    @ResponseBody
    public JSONObject getCommentByDid(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("did").toString());
            List<Comment> comments = commentService.queryCommentByDid(did);
            json.put("data", comments);
            json.put("code", 0);
        }
        return json;
    }

    @RequestMapping("/dishes/random")
    @ResponseBody
    public List<Dishes> getRandomDishes() {
        List<Dishes> dishes = dishesService.queryRandomDished();
        return dishes;
    }
}
