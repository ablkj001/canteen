package com.cuit.pojo;

import java.util.Date;

public class Room {
    private Integer rid;    //食堂ID
    private String rname;   //食堂名称
    private Date date;      //创建日期
    private Integer status = 0; //食堂状态
    private String tel;     //负责人联系方式

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

    public Room(Integer rid, String rname, Date date, Integer status, String tel) {
        this.rid = rid;
        this.rname = rname;
        this.date = date;
        this.status = status;
        this.tel = tel;
    }

    public Room(String rname, Date date, String tel) {
        this.rname = rname;
        this.date = date;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
