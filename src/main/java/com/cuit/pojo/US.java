package com.cuit.pojo;

public class US {

    private Integer usid;
    private Integer uid;
    private Integer sid;
    private String srotation;

    public US() {
    }

    public US(Integer uid, Integer sid) {
        this.uid = uid;
        this.sid = sid;
    }

    public US(Integer uid, Integer sid, String srotation) {
        this.uid = uid;
        this.sid = sid;
        this.srotation = srotation;
    }

    public US(Integer usid, Integer uid, Integer sid, String srotation) {
        this.usid = usid;
        this.uid = uid;
        this.sid = sid;
        this.srotation = srotation;
    }

    @Override
    public String toString() {
        return "US{" +
                "usid=" + usid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", srotation='" + srotation + '\'' +
                '}';
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSrotation() {
        return srotation;
    }

    public void setSrotation(String srotation) {
        this.srotation = srotation;
    }
}
