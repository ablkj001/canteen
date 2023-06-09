package com.cuit.service.Impl;

import com.cuit.mapper.NoticeMapper;
import com.cuit.pojo.Notice;
import com.cuit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 公告的Service
 */
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
     * @param title 公告标题
     * @return 公告列表
     */
    @Override
    public List<Notice> queryNotice(String title , Integer page){
        return noticeMapper.queryNotice(title , page);
    }

//    @Override
//    public Notice queryNoticeById(Integer id){
//        return noticeMapper.queryNoticeById(id);
//    }

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
     * @param notice 信息
     * @return 行数
     */
    @Override
    public Integer updateNotice(Notice notice){ return noticeMapper.updateNotice(notice); }

    /**
     * 获取总数
     * @param title 标题
     * @return 数量
     */
    public Integer countNotice(String title){ return noticeMapper.countNotice(title); }
}
