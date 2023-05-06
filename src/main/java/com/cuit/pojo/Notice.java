package com.cuit.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("notice")
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id; // 公告id
    private String content; // 公告内容
    @TableField("ndate")
    private Date noticeDate; // 更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content=" + content +
                ", noticeDate=" + noticeDate +
                '}';
    }
}
