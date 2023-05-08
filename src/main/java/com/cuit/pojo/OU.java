package com.cuit.pojo;

import java.util.Date;

public class OU {

    private Integer ouid;
    private String orderid;
    private Integer uid;
    private Date date;
    private Integer status;

    public OU() {
    }

    public OU(String orderid, Integer uid) {
        this.orderid = orderid;
        this.uid = uid;
    }

    public OU(String orderid, Integer uid, Date date) {
        this.orderid = orderid;
        this.uid = uid;
        this.date = date;
    }

    public OU(String orderid, Integer uid, Date date, Integer status) {
        this.orderid = orderid;
        this.uid = uid;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OU{" +
                "ouid=" + ouid +
                ", orderid='" + orderid + '\'' +
                ", uid=" + uid +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOuid() {
        return ouid;
    }

    public void setOuid(Integer ouid) {
        this.ouid = ouid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
