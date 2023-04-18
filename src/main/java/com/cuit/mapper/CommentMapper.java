package com.cuit.mapper;

import com.cuit.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    //获取所有评论
    List<Comment> queryAllComment();

    //添加评论
    Integer addComment(Comment comment);
}
