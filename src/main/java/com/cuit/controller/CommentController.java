package com.cuit.controller;

import com.cuit.pojo.Comment;
import com.cuit.pojo.Dishes;
import com.cuit.pojo.US;
import com.cuit.pojo.User;
import com.cuit.service.CommentService;
import com.cuit.service.DishesService;
import com.cuit.service.USService;
import com.cuit.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private USService usService;

    @Autowired
    private DishesService dishesService;

    //查询评论
    @RequestMapping("/comment")
    @ResponseBody
    public List<Comment> getCommentByDishes(@RequestBody Map map) {
        Integer did = Integer.parseInt(map.get("did").toString());
        List<Comment> comments = commentService.queryCommentByDid(did);
        return comments;
    }

    //添加评论
    @RequestMapping("/comment/add")
    @ResponseBody
    public JSONObject addComment(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer did = Integer.parseInt(map.get("foodID").toString());
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            System.out.println(map);
            Integer sid = Integer.parseInt(map.get("shopID").toString());
            String detail = map.get("comments").toString();
            Comment comment = new Comment(did, uid, sid, new Date(), detail);
            Integer i = commentService.addComment(comment);
            json.put("message", "添加成功！");
            json.put("code", 0);
        }
        return json;
    }

    //根据店铺查询评论
    @RequestMapping("/comment/shop")
    @ResponseBody
    public JSONObject shopComment(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer page = Integer.parseInt(map.get("pagenum").toString());
            User user = userService.queryUserByUame(token);
            Integer uid = user.getUid();
            US us = usService.queryUS(uid);
            Integer sid = us.getSid();
            List<Comment> comments = commentService.queryCommentBySid(page, sid);
            for (Comment comment:comments){
                Integer uid1 = comment.getUid();
                String uname = userService.queryUserById(uid1).getUname();
                Integer did = comment.getDid();
                String dname = dishesService.queryDishesByDid(did).getDname();
                comment.setUname(uname);
                comment.setDname(dname);
            }
            Integer count = commentService.countComment(sid);
            json.put("count", count);
            json.put("data", comments);
            json.put("code", 0);
        }
        return json;
    }

    //店铺界面根据菜品ID或用户ID查询评论
    @RequestMapping("/comment/query")
    @ResponseBody
    public JSONObject queryComment(@RequestBody Map map, @RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            Integer keyword = Integer.parseInt(map.get("keyword").toString());
            Integer page = Integer.parseInt(map.get("page").toString());
            List<Comment> comments = commentService.queryCommentByUidAndDid(page,keyword);
            Integer count = commentService.countQueryComment(keyword);
            json.put("count",count);
            json.put("data",comments);
            json.put("code",0);
        }
        return json;
    }
}
