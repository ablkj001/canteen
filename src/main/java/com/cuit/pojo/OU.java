package com.cuit.pojo;

import java.util.Date;

public class OU {

    private Integer ouid;
    private String orderid;
    private Integer uid;
    private Date date;

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

    @Override
    public String toString() {
        return "OU{" +
                "ouid=" + ouid +
                ", orderid='" + orderid + '\'' +
                ", uid=" + uid +
                ", date=" + date +
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
}
