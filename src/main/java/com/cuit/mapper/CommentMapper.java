package com.cuit.mapper;

import com.cuit.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    //获取所有评论
    List<Comment> queryAllComment();

    //根据菜品获取评论
    List<Comment> queryCommentByDid(Integer did);

    //添加评论
    Integer addComment(Comment comment);

    //根据页数查询评论
    List<Comment> queryCommentByPage(@Param("page") Integer page,@Param("did") Integer did);

    //根据店铺查询评论
    List<Comment> queryCommentByShop(@Param("page") Integer page,@Param("sid") Integer sid);
}
