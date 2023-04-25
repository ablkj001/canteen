package com.cuit.combine;

public class DS {
    private Integer did;    //菜品ID
    private String dname;   //菜品名
    private Integer dprice; //菜品价格
    private String dimage;  //菜品图片
    private Integer sid;    //店铺ID
    private String sname;   //店铺名称
    private String detail;  //菜品详情
    private Integer status = 0;  //菜品状态，默认为0

    public DS() {
    }

    public DS(String dname, Integer dprice, String dimage, Integer sid, String sname, String detail, Integer status) {
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.sname = sname;
        this.detail = detail;
        this.status = status;
    }

    public DS(Integer did, String dname, Integer dprice, String dimage, Integer sid, String sname, String detail, Integer status) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.dimage = dimage;
        this.sid = sid;
        this.sname = sname;
        this.detail = detail;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DS{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dprice=" + dprice +
                ", dimage='" + dimage + '\'' +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", detail='" + detail + '\'' +
                ", status=" + status +
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
