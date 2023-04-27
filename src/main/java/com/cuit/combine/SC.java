package com.cuit.combine;

public class SC {

    private Integer carid;
    private Integer sid;
    private String sname;
    private Integer did;
    private String dname;
    private String dimage;
    private Integer dprice;
    private Integer dstatus;
    private Integer count;
    private Integer status;

    public SC(Integer carid, Integer sid, String sname, Integer did, String dname, String dimage, Integer dprice, Integer dstatus, Integer count, Integer status) {
        this.carid = carid;
        this.sid = sid;
        this.sname = sname;
        this.did = did;
        this.dname = dname;
        this.dimage = dimage;
        this.dprice = dprice;
        this.dstatus = dstatus;
        this.count = count;
        this.status = status;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDimage() {
        return dimage;
    }

    public void setDimage(String dimage) {
        this.dimage = dimage;
    }

    public Integer getDprice() {
        return dprice;
    }

    public void setDprice(Integer dprice) {
        this.dprice = dprice;
    }

    public Integer getDstatus() {
        return dstatus;
    }

    public void setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SC() {
    }

    public SC(String sname, String dname, String dimage, Integer dprice, Integer dstatus, Integer count, Integer status) {
        this.sname = sname;
        this.dname = dname;
        this.dimage = dimage;
        this.dprice = dprice;
        this.dstatus = dstatus;
        this.count = count;
        this.status = status;
    }

    public SC(Integer sid, String sname, Integer did, String dname, String dimage, Integer dprice, Integer dstatus, Integer count, Integer status) {
        this.sid = sid;
        this.sname = sname;
        this.did = did;
        this.dname = dname;
        this.dimage = dimage;
        this.dprice = dprice;
        this.dstatus = dstatus;
        this.count = count;
        this.status = status;
    }

}
