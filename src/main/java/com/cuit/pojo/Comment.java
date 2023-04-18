package com.cuit.pojo;

import java.util.Date;

public class Comment {

    private Integer cid;    //评论ID
    private Integer did;    //菜品ID
    private Integer uid;    //用户ID
    private Integer sid;    //店铺ID
    private Date date;      //评论日期
    private String detail;  //评论内容

    public Comment() {
    }

    public Comment(Integer did, Integer uid, Integer sid, Date date, String detail) {
        this.did = did;
        this.uid = uid;
        this.sid = sid;
        this.date = date;
        this.detail = detail;
    }

    public Comment(Integer cid, Integer did, Integer uid, Integer sid, Date date, String detail) {
        this.cid = cid;
        this.did = did;
        this.uid = uid;
        this.sid = sid;
        this.date = date;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", did=" + did +
                ", uid=" + uid +
                ", sid=" + sid +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
