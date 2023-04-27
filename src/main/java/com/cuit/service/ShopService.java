package com.cuit.service;

import com.cuit.pojo.Shop;

import java.util.List;

public interface ShopService {

    //通过食堂id查询店铺
    List<Shop> queryShopByRid(Integer rid);

    //添加店铺
    Integer addShop(Shop shop);

    //移除店铺
    Integer deleteShop(Integer sid);

    //根据店铺id获取店铺对象
    Shop queryShopBySid(Integer sid);
}
