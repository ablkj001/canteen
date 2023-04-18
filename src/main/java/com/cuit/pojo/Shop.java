package com.cuit.pojo;

public class Shop {

    private Integer sid;        //商铺ID
    private String sname;       //商铺名称
    private Integer rid;        //食堂ID
    private String location;    //所处位置
    private String manager;     //负责人
    private String tel;         //负责人联系方式

    public Shop() {
    }

    public Shop(String sname, Integer rid, String location, String manager, String tel) {
        this.sname = sname;
        this.rid = rid;
        this.location = location;
        this.manager = manager;
        this.tel = tel;
    }

    public Shop(Integer sid, String sname, Integer rid, String location, String manager, String tel) {
        this.sid = sid;
        this.sname = sname;
        this.rid = rid;
        this.location = location;
        this.manager = manager;
        this.tel = tel;
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
