package com.cuit.mapper;

import com.cuit.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    //往订单表中插入新的订单
    Integer addOrder(Order order);

    //用户端分页显示订单
    //用户端订单列表，同一个流水号下的店铺属于同一个订单
    List<Order> queryOrderUserList(@Param("uid") Integer uid);

    //当前用户的订单总数
    Integer countUserOrder(@Param("uid") Integer uid);

    //店铺的订单总数
    Integer countShopOrder(@Param("sid") Integer sid);

    //店铺端分页显示订单
    //店铺端订单列表，同一个订单号下的订单属于一个订单
    List<Order> queryOrderManagerList(@Param("sid") Integer sid);

    //店铺端修改订单状态
    Integer changeOrderStatus(@Param("did") Integer did,@Param("orderid") String orderid);

    //根据orderid查询订单详情
    List<Order> queryOrderByOrderid(@Param("orderid") String orderid);
}
