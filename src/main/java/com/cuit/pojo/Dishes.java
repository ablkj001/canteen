package com.cuit.pojo;

public class Dishes {

    private Integer did;    //菜品ID
    private String dname;   //菜品名
    private Integer dprice; //菜品价格
    private String dimage;  //菜品图片
    private Integer sid;    //店铺ID
    private String detail;  //菜品详情
    private Integer status = 0;  //菜品状态，默认为0
    private String swiper;  //菜品轮播图
    private Integer dishelevel = 0; //菜品推介等级
    private Integer swiperlevel = 0;    //轮播图推介等级

    public Dishes() {
    }

    public Dishes(String dname, Integer dprice, String dimage, Integer sid, String detail) {
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
    }

    public Dishes(String dname, Integer dprice, String dimage, Integer sid, String detail, String swiper) {
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
        this.swiper = swiper;
    }

    public Dishes(String dname, Integer dprice, String dimage, Integer sid, String detail, Integer status) {
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
        this.status = status;
    }

    public Dishes(Integer did, String dname, Integer dprice, String dimage, Integer sid, String detail) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
    }

    public Dishes(Integer did, String dname, Integer dprice, String dimage, Integer sid, String detail, Integer status, String swiper, Integer dishelevel, Integer swiperlevel) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.detail = detail;
        this.status = status;
        this.swiper = swiper;
        this.dishelevel = dishelevel;
        this.swiperlevel = swiperlevel;
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
                ", status=" + status +
                ", swiper='" + swiper + '\'' +
                ", dishelevel=" + dishelevel +
                ", swiperlevel=" + swiperlevel +
                '}';
    }

    public String getSwiper() {
        return swiper;
    }

    public void setSwiper(String swiper) {
        this.swiper = swiper;
    }

    public Integer getDishelevel() {
        return dishelevel;
    }

    public void setDishelevel(Integer dishelevel) {
        this.dishelevel = dishelevel;
    }

    public Integer getSwiperlevel() {
        return swiperlevel;
    }

    public void setSwiperlevel(Integer swiperlevel) {
        this.swiperlevel = swiperlevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
