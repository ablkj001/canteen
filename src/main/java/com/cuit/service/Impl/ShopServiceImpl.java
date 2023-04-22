package com.cuit.service.Impl;

import com.cuit.mapper.ShopMapper;
import com.cuit.pojo.Shop;
import com.cuit.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> queryShopByRid(Integer rid) {
        List<Shop> shops = shopMapper.queryShopByRid(rid);
        return shops;
    }

    @Override
    public Integer addShop(Shop shop) {
        Integer i = shopMapper.addShop(shop);
        return i;
    }

    @Override
    public Integer deleteShop(Integer sid) {
        Integer i =shopMapper.deleteShop(sid);
        return i;
    }

    @Override
    public Shop queryShopBySid(Integer sid) {
        Shop shop = shopMapper.queryShopBySid(sid);
        return shop;
    }
}
