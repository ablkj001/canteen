package com.cuit.mapper;

import com.cuit.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    //新增订单
    Integer addOrder(Order order);

    //支付订单（删除订单）
    Integer deleteOrder(Integer onumber);

    //用户端查询订单详情
    List<Order> queryOrderByOnumber(Integer onumber);

    //根据用户显示订单列表
    List<Order> queryOrderByUid(Integer uid);

    //店铺端查询订单
}
