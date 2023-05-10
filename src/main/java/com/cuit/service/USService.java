package com.cuit.service;

import com.cuit.pojo.US;

public interface USService {

    //添加管理员与店铺的关系
    Integer addService(Integer uid,Integer sid);

    //根据uid获取用户与店铺之间的关系
    US queryUS(Integer uid);

    //根据sid获取用户与店铺之间的关系
    US queryUSBySid(Integer sid);
}
