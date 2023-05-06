package com.cuit.service.Impl;

import cn.hutool.core.date.DateUtil;
import com.cuit.mapper.NoticeMapper;
import com.cuit.pojo.Notice;
import com.cuit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 添加公告
     * @param notice 公告
     * @return 行数
     */
    @Override
    public Integer addNotice(Notice notice){
        return noticeMapper.addNotice(notice);
    }

    /**
     * 根据公告内容模糊查询
     * @param content 公告内容
     * @return 公告列表
     */
    @Override
    public List<Notice> queryNotice(String content , Integer page){
        return noticeMapper.queryNotice(content , page);
    }

    @Override
    public Notice queryNoticeById(Integer id){
        return noticeMapper.queryNoticeById(id);
    }

    /**
     * 删除公告
     * @param id 公告id
     * @return 行数
     */
    @Override
    public Integer deleteNotice(Integer id){
        return noticeMapper.deleteNotice(id);
    }

    /**
     * 编辑公告
     * @param id id
     * @param content 内容
     * @param noticeDate 时间
     * @return 行数
     */
    @Override
    public Integer updateNotice(Integer id, String content, Date noticeDate){
        return noticeMapper.updateNotice(id,content,noticeDate);
    }

    // 获取公告条数
    public Integer countNotice(String content){
        return noticeMapper.countNotice(content);
    }
}
