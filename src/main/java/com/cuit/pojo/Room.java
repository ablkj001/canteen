package com.cuit.pojo;

import java.util.Date;

public class Room {
    private Integer rid;    //食堂ID
    private String rname;   //食堂名称
    private Date date;      //创建日期
    private Integer status; //食堂状态

    public Room() {
    }

    public Room(String rname, Date date) {
        this.rname = rname;
        this.date = date;
    }

    public Room(Integer rid, String rname, Date date) {
        this.rid = rid;
        this.rname = rname;
        this.date = date;
    }

    public Room(Integer rid, String rname, Date date, Integer status) {
        this.rid = rid;
        this.rname = rname;
        this.date = date;
        this.status = status;
    }

    public Room(String rname, Date date, Integer status) {
        this.rname = rname;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
