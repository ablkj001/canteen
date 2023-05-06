package com.cuit.mapper;

import com.cuit.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    // 添加公告
    Integer addNotice(Notice notice);

    // 查询公告
    List<Notice> queryNotice(@Param("content") String content, @Param("page") Integer page);
    Notice queryNoticeById(@Param("nid") Integer id);

    // 删除公告
    Integer deleteNotice(@Param("nid") Integer id);

    // 编辑公告
    Integer updateNotice(@Param("nid") Integer id, @Param("content") String content, @Param("noticeDate") Date noticeDate);

    // 获取公告条数
    Integer countNotice(@Param("content") String content);
}
