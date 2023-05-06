package com.cuit.pojo;

import java.util.Date;

public class Order {

    private Integer oid;                //订单主键
    private String onumber;             //流水号
    private String orderid;             //订单ID
    private Integer uid;                //用户ID
    private Integer sid;                //店铺ID
    private Integer did;                //菜品ID
    private Integer payment;            //总金额
    private Integer quantity;           //菜品数量
    private Date bdate;                 //购买日期
    private Integer ostatus = 1;        //默认为未完成状态0为已完成，1为未完成

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", onumber='" + onumber + '\'' +
                ", orderid='" + orderid + '\'' +
                ", uid=" + uid +
                ", sid=" + sid +
                ", did=" + did +
                ", payment=" + payment +
                ", quantity=" + quantity +
                ", bdate=" + bdate +
                ", ostatus=" + ostatus +
                '}';
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public Order() {
    }

    public Order(String onumber, Integer uid, Integer did, Integer payment, Integer quantity, Date bdate, Integer ostatus) {
        this.onumber = onumber;
        this.uid = uid;
        this.did = did;
        this.payment = payment;
        this.quantity = quantity;
        this.bdate = bdate;
        this.ostatus = ostatus;
    }

    public Order(String onumber, String orderid, Integer uid, Integer sid, Integer did, Integer payment, Integer quantity, Date bdate, Integer ostatus) {
        this.onumber = onumber;
        this.orderid = orderid;
        this.uid = uid;
        this.sid = sid;
        this.did = did;
        this.payment = payment;
        this.quantity = quantity;
        this.bdate = bdate;
        this.ostatus = ostatus;
    }

    public Order(String onumber, Integer uid, Integer sid, Integer did, Integer payment, Integer quantity, Date bdate, Integer ostatus) {
        this.onumber = onumber;
        this.uid = uid;
        this.sid = sid;
        this.did = did;
        this.payment = payment;
        this.quantity = quantity;
        this.bdate = bdate;
        this.ostatus = ostatus;
    }

    public Order(Integer oid, String onumber, Integer uid, Integer did, Integer payment, Integer quantity, Date bdate, Integer ostatus) {
        this.oid = oid;
        this.onumber = onumber;
        this.uid = uid;
        this.did = did;
        this.payment = payment;
        this.quantity = quantity;
        this.bdate = bdate;
        this.ostatus = ostatus;
    }

    public Order(String onumber, String orderid, Integer uid, Integer sid, Integer did, Integer payment, Integer quantity, Date bdate) {
        this.onumber = onumber;
        this.orderid = orderid;
        this.uid = uid;
        this.sid = sid;
        this.did = did;
        this.payment = payment;
        this.quantity = quantity;
        this.bdate = bdate;
    }
}
