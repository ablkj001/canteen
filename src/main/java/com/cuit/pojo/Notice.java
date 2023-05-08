package com.cuit.pojo;

import java.util.Date;

public class Notice {
    private Integer nid; // 公告id
    private String title; // 标题
    private String content; // 公告内容
    private Date noticeDate; // 更新时间

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) { this.noticeDate = noticeDate;
    }
}
