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
    public List<Comment> queryCommentByDid(Integer did) {
        List<Comment> comments = commentMapper.queryCommentByDid(did);
        return comments;
    }

    @Override
    public Integer addComment(Comment comment) {
        Integer i = commentMapper.addComment(comment);
        return i;
    }

    @Override
    public List<Comment> queryCommentByPage(Integer currPage,Integer did) {
        List<Comment> comments = commentMapper.queryCommentByPage(currPage,did);
        return comments;
    }

    @Override
    public Integer CountCommentsByDid(Integer did) {
        List<Comment> comments = commentMapper.queryCommentByDid(did);
        return comments.size();
    }

    @Override
    public List<Comment> queryCommentBySid(Integer page, Integer sid) {
        List<Comment> comments = commentMapper.queryCommentByShop(page,sid);
        return comments;
    }

    @Override
    public Integer countComment(Integer sid) {
        Integer i = commentMapper.countCommentBySid(sid);
        return i;
    }

    @Override
    public List<Comment> queryCommentByUidAndDid(Integer page, Integer keyword) {
        List<Comment> comments = commentMapper.queryCommentByUidAndDid(keyword,page);
        return comments;
    }

    @Override
    public Integer countQueryComment(Integer keyword) {
        Integer count = commentMapper.countQueryComment(keyword);
        return count;
    }
}
