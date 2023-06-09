package com.cuit.pojo;

public class ShopCar {

    private Integer carid;      //购物车ID
    private Integer uid;        //用户ID
    private Integer did;        //菜品ID
    private Integer sid;        //店铺ID
    private Integer count;      //菜品数量
    private Integer status = 1;     //购物车勾选状态,1为未勾选，0为已勾选

    public ShopCar() {
    }

    public ShopCar(Integer uid, Integer did, Integer sid, Integer count) {
        this.uid = uid;
        this.did = did;
        this.sid = sid;
        this.count = count;
    }

    public ShopCar(Integer carid, Integer uid, Integer did, Integer sid, Integer count) {
        this.carid = carid;
        this.uid = uid;
        this.did = did;
        this.sid = sid;
        this.count = count;
    }



    public ShopCar(Integer uid, Integer did, Integer sid) {
        this.uid = uid;
        this.did = did;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "carid=" + carid +
                ", uid=" + uid +
                ", did=" + did +
                ", sid=" + sid +
                ", count=" + count +
                ", status=" + status +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
