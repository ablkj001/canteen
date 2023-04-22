package com.cuit.pojo;

public class Dishes {

    private Integer did;    //菜品ID
    private String dname;   //菜品名
    private Integer dprice; //菜品价格
    private String dimage;  //菜品图片
    private Integer sid;    //店铺ID
    private String detail;  //菜品详情

    public Dishes() {
    }

    public Dishes(String dname, Integer dprice, String dimage, Integer sid, String detail) {
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
    }

    public Dishes(Integer did, String dname, Integer dprice, String dimage, Integer sid, String detail) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dprice=" + dprice +
                ", dimage='" + dimage + '\'' +
                ", sid=" + sid +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDprice() {
        return dprice;
    }

    public void setDprice(Integer dprice) {
        this.dprice = dprice;
    }

    public String getDimage() {
        return dimage;
    }

    public void setDimage(String dimage) {
        this.dimage = dimage;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
