package com.cuit.service;

import com.cuit.pojo.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> queryShopByRid(Integer rid);

    Integer addShop(Shop shop);

    Integer deleteShop(Integer sid);

    Shop queryShopBySid(Integer sid);
}
