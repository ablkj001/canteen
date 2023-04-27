package com.cuit.pojo;

public class User {

    private Integer uid;    //用户ID
    private String uname;   //用户名
    private String pwd;     //密码
    private String flag;    //用户标识
    private String tel;     //联系方式
    private String uavatar; //用户头像
    private Integer status; //用户状态

    public User() {
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public User(String uname, String pwd, String flag, String tel) {
        this.uname = uname;
        this.pwd = pwd;
        this.flag = flag;
        this.tel = tel;
    }

    public User(Integer uid, String uname, String pwd, String flag, String tel, String uavatar) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.flag = flag;
        this.tel = tel;
        this.uavatar = uavatar;
    }

    public User(String uname, String pwd, String flag, String tel, String uavatar, Integer status) {
        this.uname = uname;
        this.pwd = pwd;
        this.flag = flag;
        this.tel = tel;
        this.uavatar = uavatar;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", flag='" + flag + '\'' +
                ", tel='" + tel + '\'' +
                ", uavatar='" + uavatar + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUavatar() {
        return uavatar;
    }

    public void setUavatar(String uavatar) {
        this.uavatar = uavatar;
    }
}
