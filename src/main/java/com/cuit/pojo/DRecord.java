package com.cuit.pojo;

public class DRecord {

    private Integer dsid;
    private Integer did;
    private Integer sid;

    public DRecord() {
    }

    public DRecord(Integer did, Integer sid) {
        this.did = did;
        this.sid = sid;
    }

    public DRecord(Integer dsid, Integer did, Integer sid) {
        this.dsid = dsid;
        this.did = did;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "DRecord{" +
                "dsid=" + dsid +
                ", did=" + did +
                ", sid=" + sid +
                '}';
    }

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
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
}
