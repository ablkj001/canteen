package com.cuit.combine;

public class SC {

    private String sname;
    private String dname;
    private String dimage;
    private Integer dprice;
    private Integer dstatus;
    private Integer count;
    private Integer status;

    @Override
    public String toString() {
        return "SC{" +
                "sname='" + sname + '\'' +
                ", dname='" + dname + '\'' +
                ", dimage='" + dimage + '\'' +
                ", dprice=" + dprice +
                ", dstatus=" + dstatus +
                ", count=" + count +
                ", status=" + status +
                '}';
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
}
