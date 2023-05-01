package com.cuit.service;

import com.cuit.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> queryAllComment();

    List<Comment> queryCommentByDid(Integer did);

    Integer addComment(Comment comment);

    List<Comment> queryCommentByPage(Integer currPage,Integer did);

    Integer CountCommentsByDid(Integer did);

    List<Comment> queryCommentBySid(Integer page,Integer sid);
}
