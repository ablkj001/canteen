package com.cuit.service;

import com.cuit.pojo.ShopCar;

import java.util.List;

public interface ShopCarService {

    //往购物车中添加菜品
    Integer addShopCar(ShopCar shopCar);

    //查询用户购物车中的物品
    List<ShopCar> queryShopcarByUid(Integer uid);

    //移除购物车中的菜品
    Integer deleteShopCar(Integer carid);

    //购物车中修改菜品数量
    Integer updateShopCar(ShopCar shopCar);

    //购物车中的勾选菜品
    Integer updateShopCarStatus(ShopCar shopCar);

    //根据carid获取购物车信息
    ShopCar queryShopCar(Integer carid);

}
