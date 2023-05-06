package com.cuit.service;

import com.cuit.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NoticeService {
    // 添加公告
    Integer addNotice(Notice notice);

    // 查询公告
    List<Notice> queryNotice(String content, Integer page);
    Notice queryNoticeById(Integer id);

    // 删除公告
    Integer deleteNotice(Integer id);

    // 编辑公告
    Integer updateNotice(Integer id, String content, Date noticeDate);

    // 获取公告条数
    Integer countNotice(String content);
}
