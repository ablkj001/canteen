package com.cuit.controller;

import cn.hutool.core.date.DateUtil;
import com.cuit.pojo.Notice;
import com.cuit.service.NoticeService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 公告的控制类
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 添加公告
     * @param map 参数体
     * @param token token
     * @return 执行结果
     */
    @RequestMapping("/notice/add")
    @ResponseBody
    public JSONObject addNotice(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            // 创建公告对象
            Notice notice = new Notice();

            // 初始化对象
            notice.setContent(map.get("content").toString());
            notice.setNoticeDate(DateUtil.date());

            // 执行添加操作
            Integer i = noticeService.addNotice(notice);

            // 设置返回值
            if (i == 1){
                json.put("message", "公告添加成功！");
                json.put("code", 0);
            } else {
                json.put("message", "公告添加失败！");
                json.put("code", 1);
            }
        }
        return json;
    }

    /**
     * 删除公告
     * @param map 参数体
     * @param token token
     * @return 执行结果
     */
    @RequestMapping("/notice/delete")
    @ResponseBody
    public JSONObject deleteNotice(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {
            // 获取请求体中的参数
            Integer id = Integer.parseInt(map.get("id").toString());

            // 执行删除操作
            Integer result = noticeService.deleteNotice(id);

            // 设置返回值
            if (result > 0) {
                json.put("message", "公告删除成功！");
                json.put("code", 0);
            } else {
                json.put("message", "公告删除失败！");
                json.put("code", 1);
            }
        }
        return json;
    }

    /**
     * 编辑公告
     * @param map 参数体
     * @param token token
     * @return 执行结果
     */
    @RequestMapping("/notice/update")
    @ResponseBody
    public JSONObject updateNotice(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 获取值
            Integer id = Integer.parseInt(map.get("id").toString());
            String content = map.get("content").toString();
            Date noticeDate = DateUtil.date();

            // 执行编辑操作
            Integer result = noticeService.updateNotice(id, content, noticeDate);

            // 设置返回值
            if (result > 0) {
                json.put("message", "公告更新成功！");
                json.put("code", 0);
            } else {
                json.put("message", "公告更新失败！");
                json.put("code", 1);
            }
        }
        return json;
    }

    /**
     * 查询公告
     * @param map 参数体
     * @param token token
     * @return 列表和总数
     */
    @RequestMapping("/notice")
    @ResponseBody
    public JSONObject getNoticeByContent(@RequestBody Map map, @RequestHeader("Authorization") String token) {
        JSONObject json = new JSONObject();
        if (token == null) {
            json.put("data", null);
            json.put("code", 1);
        } else {

            // 公告内容
            String content = map.get("content").toString();

            // 页数
            Integer page = Integer.parseInt(map.get("page").toString());

            // 执行查询操作
            List<Notice> notices = noticeService.queryNotice(content,page);

            // 获取数据条数
            int count = noticeService.countNotice(content);

            // 设置返回值
            json.put("data", notices);
            json.put("count", count);
            json.put("code",0);
        }
        return json;
    }
}
