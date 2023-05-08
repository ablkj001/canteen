package com.cuit.combine;

public class DI {

    private Integer did;
    private String dname;
    private Integer dprice;
    private Integer count;
    private Integer payment;
    private Integer status;

    public DI() {
    }

    public DI(Integer did, String dname, Integer dprice, Integer count, Integer payment) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.count = count;
        this.payment = payment;
    }

    public DI(Integer did, String dname, Integer dprice, Integer count, Integer payment, Integer status) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.count = count;
        this.payment = payment;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DI{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dprice=" + dprice +
                ", count=" + count +
                ", payment=" + payment +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
