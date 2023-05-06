package com.cuit.service;

import com.cuit.pojo.Comment;

import java.util.List;

public interface CommentService {

    //获取所有评论
    List<Comment> queryAllComment();

    //根据菜品获取评论
    List<Comment> queryCommentByDid(Integer did);

    //用户添加评论
    Integer addComment(Comment comment);

    //根据菜品ID分页获取评论
    List<Comment> queryCommentByPage(Integer currPage,Integer did);

    //根据菜品ID获取评论总数
    Integer CountCommentsByDid(Integer did);

    //根据店铺分页获取评论
    List<Comment> queryCommentBySid(Integer page,Integer sid);

    //获取评论总数
    Integer countComment(Integer sid);

    //根据菜品ID或用户ID分页查询评论
    List<Comment> queryCommentByUidAndDid(Integer page,Integer keyword);

    //获取查询后评论的总数
    Integer countQueryComment(Integer keyword);
}
