package com.cuit.service.Impl;

import com.cuit.mapper.CommentMapper;
import com.cuit.pojo.Comment;
import com.cuit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryAllComment() {
        List<Comment> comments = commentMapper.queryAllComment();
        return comments;
    }

    @Override
    public Integer addComment(Comment comment) {
        Integer i = commentMapper.addComment(comment);
        return i;
    }
}
