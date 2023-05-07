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
    List<Notice> queryNotice(@Param("title") String title, @Param("page") Integer page);

    // 仅在测试类中测试使用,使用id查询
    Notice queryNoticeById(@Param("nid") Integer id);

    // 删除公告
    Integer deleteNotice(@Param("nid") Integer id);

    // 编辑公告
    Integer updateNotice(Notice notice);

    // 获取公告条数
    Integer countNotice(@Param("title") String title);
}
