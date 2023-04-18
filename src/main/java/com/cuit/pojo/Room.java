package com.cuit.pojo;

import java.util.Date;

public class Room {
    private Integer rid;    //食堂ID
    private String rname;   //食堂名称
    private Date date;      //创建日期

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

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", date=" + date +
                '}';
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
