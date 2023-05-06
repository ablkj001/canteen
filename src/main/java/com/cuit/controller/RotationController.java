package com.cuit.controller;

import com.cuit.pojo.Dishes;
import com.cuit.service.RotationService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 轮播图控制类
 */
@Controller
public class RotationController {
    @Autowired
    private RotationService rotationService;

    /**
     * 轮播图晋升
     * @param map 参数体
     * @param token token
     * @return 晋升情况
     */
    @RequestMapping("/rotation/promote")
    @ResponseBody
    public JSONObject updateRotationPromote(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 获取值
            Integer id = Integer.parseInt(map.get("id").toString());

            // 执行晋升操作
            Integer result = rotationService.updateRotationPromote(id);

            // 设置返回值
            if (result > 0) {
                json.put("message", "推荐等级晋升成功！");
                json.put("code", 0);
            } else {
                json.put("message", "推荐等级晋升失败！");
                json.put("code", 1);
            }
        }
        return json;
    }

    /**
     * 轮播图降级
     * @param map
     * @param token
     * @return
     */
    @RequestMapping("/rotation/reduce")
    @ResponseBody
    public JSONObject updateRotationReduce(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 获取值
            Integer id = Integer.parseInt(map.get("id").toString());

            // 执行降级操作
            Integer result = rotationService.updateRotationReduce(id);

            // 设置返回值
            if (result > 0) {
                json.put("message", "推荐等级降级成功！");
                json.put("code", 0);
            } else {
                json.put("message", "推荐等级降级失败！");
                json.put("code", 1);
            }
        }
        return json;
    }

    /**
     * 查询推荐等级为1的轮播图信息
     * @param map 参数体
     * @param token token
     * @return 轮播图
     */
    @RequestMapping("/rotation/first")
    @ResponseBody
    public JSONObject queryFirstGrade(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 页数
            Integer page = Integer.parseInt(map.get("page").toString());

            // 执行查询操作
            List<Dishes> dishes = rotationService.queryFirstGrade(page);

            // 获取数据条数
            int count = rotationService.countRotation(1);

            // 设置返回值
            json.put("data", dishes);
            json.put("count", count);
        }
        return json;
    }

    /**
     * 查询推荐等级为2的轮播图
     * @param map 参数体
     * @param token token
     * @return 轮播图信息
     */
    @RequestMapping("/rotation/second")
    @ResponseBody
    public JSONObject querySecondGrade(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 页数
            Integer page = Integer.parseInt(map.get("page").toString());

            // 执行查询操作
            List<Dishes> dishes = rotationService.querySecondGrade(page);

            // 获取数据条数
            int count = rotationService.countRotation(2);

            // 设置返回值
            json.put("data", dishes);
            json.put("count", count);
        }
        return json;
    }
}
