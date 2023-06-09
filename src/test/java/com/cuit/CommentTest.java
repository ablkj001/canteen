package com.cuit;

import com.cuit.controller.CommentController;
import com.cuit.mapper.CommentMapper;
import com.cuit.pojo.Comment;
import com.cuit.service.CommentService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //按照指定方法运行
public class CommentTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @Test
    void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){
        Comment comment = new Comment(1,2,1,new Date(),"测试");
        Integer i = commentMapper.addComment(comment);
        List<Comment> comments = commentMapper.queryAllComment();
    }

    @Test
    public void testB(){
        Integer i = commentService.CountCommentsByDid(1);
        List<Comment> comments = commentService.queryCommentByPage(1,1);
        System.out.println(i);
        System.out.println(comments);
    }

    @Test
    public void testC(){
        List<Comment> comments = commentMapper.queryCommentByPage(4,1);
    }
}
