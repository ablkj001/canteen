package com.cuit.service;

import com.cuit.pojo.Order;

import java.util.List;

public interface OrderService {

    //新增订单
    Integer addOrder(Order order);

    //支付订单
    Integer payOrder(Integer onumber);

    //用户端查询订单详情
    List<Order> queryOrderByOnumber(Integer onumber);

    //用户端显示订单列表
    List<Order> queryOrderByUid(Integer uid);
}
