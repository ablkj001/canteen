package com.cuit.service;

import com.cuit.pojo.Notice;

import java.util.Date;
import java.util.List;

public interface NoticeService {
    // 添加公告
    Integer addNotice(Notice notice);

    // 查询公告
    List<Notice> queryNotice(String title, Integer page);

//    Notice queryNoticeById(Integer id);

    // 删除公告
    Integer deleteNotice(Integer id);

    // 编辑公告
    Integer updateNotice(Notice notice);

    // 获取公告条数
    Integer countNotice(String title);
}
