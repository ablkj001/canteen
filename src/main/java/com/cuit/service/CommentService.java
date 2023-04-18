package com.cuit.service;

import com.cuit.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> queryAllComment();

    Integer addComment(Comment comment);
}
