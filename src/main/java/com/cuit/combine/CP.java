package com.cuit.combine;

import com.cuit.pojo.Comment;

import java.util.List;

public class CP {

    Integer total;

    List<Comment> comments;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public CP() {
    }

    public CP(Integer total, List<Comment> comments) {
        this.total = total;
        this.comments = comments;
    }
}
