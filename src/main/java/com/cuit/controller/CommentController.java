package com.cuit.controller;

import com.cuit.pojo.Comment;
import com.cuit.service.CommentService;
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

    @RequestMapping("/comment")
    @ResponseBody
    public List<Comment> getCommentByDishes(@RequestBody Map map){
        Integer did = Integer.parseInt(map.get("did").toString());
        List<Comment> comments = commentService.queryCommentByDid(did);
        return comments;
    }

    @RequestMapping("/comment/add")
    @ResponseBody
    public JSONObject addComment(@RequestBody Map map,@RequestHeader("Authorization") String token){
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        }else {
            Integer did = Integer.parseInt(map.get("foodID").toString());
            Integer uid = Integer.parseInt(token);
            System.out.println(map);
            Integer sid = Integer.parseInt(map.get("shopID").toString());
            String detail = map.get("comments").toString();
            Comment comment = new Comment(did,uid,sid,new Date(),detail);
            Integer i = commentService.addComment(comment);
            json.put("message","添加成功！");
            json.put("code",0);
        }
        return json;
    }
}
