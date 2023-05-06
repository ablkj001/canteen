package com.cuit.combine;

public class DI {

    private Integer did;
    private String dname;
    private Integer dprice;
    private Integer count;
    private Integer payment;

    public DI() {
    }

    public DI(Integer did, String dname, Integer dprice, Integer count, Integer payment) {
        this.did = did;
        this.dname = dname;
        this.dprice = dprice;
        this.count = count;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "DI{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dprice=" + dprice +
                ", count=" + count +
                ", payment=" + payment +
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
}
