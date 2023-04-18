package com.cuit;

import com.cuit.mapper.CommentMapper;
import com.cuit.pojo.Comment;
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
}
