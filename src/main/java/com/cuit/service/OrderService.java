package com.cuit.service;

import com.cuit.combine.OR;

import java.util.List;

public interface OrderService {

    //购物车支付后生成订单（增加订单，支付功能）
    //从用户购物车中删除相应菜品，再在订单中加入相应的菜品
    Integer addOrder(Integer uid);

    //用户在菜品界面购买菜品
    //在菜品界面点击购买后生成一个订单
    Integer insertOrder(Integer uid,Integer sid,Integer did,Integer count);

    //用户端分页显示订单
    List<OR> queryOrderByUid(Integer uid,Integer page,Integer pagesize,Integer isdone);

    //店铺端分页显示订单，逻辑和用户端一样
    List<OR> queryOrderBySid(Integer sid,Integer page,Integer pagesize,Integer isdone);

    //用户端订单分三种状态:1.未完成 2.部分完成 3.已完成
    //店铺端改变订单状态
    Integer changeOrderStatus(Integer did,String orderid);

    //获取用户端订单的总数
    Integer countOrderByUid(Integer uid,Integer isdone);

    //获取店铺端订单的总数
    Integer countOrderBySid(Integer sid,Integer isdone);
}
