package com.cuit.pojo;

import java.util.Date;

public class OS {

    private Integer osid;
    private String orderid;
    private Integer sid;
    private Date date;

    public OS() {
    }

    public OS(String orderid, Integer sid) {
        this.orderid = orderid;
        this.sid = sid;
    }

    public OS(String orderid, Integer sid, Date date) {
        this.orderid = orderid;
        this.sid = sid;
        this.date = date;
    }

    @Override
    public String toString() {
        return "OS{" +
                "osid=" + osid +
                ", orderid='" + orderid + '\'' +
                ", sid=" + sid +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getOsid() {
        return osid;
    }

    public void setOsid(Integer osid) {
        this.osid = osid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
