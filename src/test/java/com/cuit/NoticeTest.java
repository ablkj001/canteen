package com.cuit;

import cn.hutool.core.date.DateUtil;
import com.cuit.mapper.NoticeMapper;
import com.cuit.pojo.Notice;
import com.cuit.service.NoticeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class NoticeTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    NoticeService noticeService;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){

        Notice notice = new Notice();
        notice.setNid(1);
        notice.setContent("测试内容1");
        notice.setNoticeDate(DateUtil.date());

        System.out.println(notice);

        Integer i = noticeMapper.addNotice(notice);
        List<Notice> notices = noticeMapper.queryNotice("测试",1);
        int count = noticeMapper.countNotice("测试");

        System.out.println(notices);
        System.out.println(count);
    }

    @Test
    public void testB(){
        Integer id = 1;
        Notice notice = noticeMapper.queryNoticeById(id);
        System.out.println(notice);

        String content = "更新后的内容";
        Date noticeDate = DateUtil.date();
        Integer result = noticeMapper.updateNotice(id,content,noticeDate);
        System.out.println(result);
    }

    @Test
    public void testC(){
        Integer id = 1;
        Integer result = noticeMapper.deleteNotice(id);
        System.out.println(result);
    }
}

