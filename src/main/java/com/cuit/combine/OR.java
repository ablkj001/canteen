package com.cuit.combine;

import java.util.Date;
import java.util.List;

public class OR {

    private String orderid;
    private String uname;
    private List<DI> dis;
    private Integer count;
    private Date date;
    private Integer status;

    public OR() {
    }

    public OR(String orderid, String uname, List<DI> dis, Integer count, Date date, Integer status) {
        this.orderid = orderid;
        this.uname = uname;
        this.dis = dis;
        this.count = count;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OR{" +
                "orderid='" + orderid + '\'' +
                ", uname='" + uname + '\'' +
                ", dis=" + dis +
                ", count=" + count +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<DI> getDis() {
        return dis;
    }

    public void setDis(List<DI> dis) {
        this.dis = dis;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
