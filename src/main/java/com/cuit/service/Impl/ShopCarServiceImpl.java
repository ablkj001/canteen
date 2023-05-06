package com.cuit.service.Impl;

import com.cuit.mapper.ShopCarMapper;
import com.cuit.pojo.ShopCar;
import com.cuit.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public Integer addShopCar(ShopCar shopCar) {
        Integer i;
        //如果原先购物车中没有该菜品则直接添加菜品到购物车中
        Integer count = shopCarMapper.countShopCarByDid(shopCar.getDid(), shopCar.getUid());
        if(count == null){
            count = 0;
        }
        if (count == 0 && count + shopCar.getCount() <= 20) {
            i = shopCarMapper.addShopCar(shopCar);
        } else if (count + shopCar.getCount() <= 20) {
            i = shopCarMapper.updateShopCarByDid(shopCar.getDid(), shopCar.getUid(), shopCar.getCount());
        } else {
            i = 0;
        }
        return i;
    }

    @Override
    public List<ShopCar> queryShopcarByUid(Integer uid) {
        List<ShopCar> shopCars = shopCarMapper.queryShopcarByUid(uid);
        return shopCars;
    }

    @Override
    public Integer deleteShopCar(Integer carid) {
        Integer i = shopCarMapper.deleteShopCar(carid);
        return i;
    }

    @Override
    public Integer updateShopCar(ShopCar shopCar) {
        Integer i = 0;
        //如果原先购物车中没有该菜品则直接添加菜品到购物车中
        Integer count = shopCarMapper.countShopCarByDid(shopCar.getDid(), shopCar.getUid());
        if(count == null){
            count = 0;
        }
        if (count + shopCar.getCount() <= 20){
            i = shopCarMapper.updateShopCar(shopCar.getDid(), shopCar.getUid(), shopCar.getCount());
        }
        return i;
    }

    @Override
    public Integer updateShopCarStatus(ShopCar shopCar) {
        Integer i = shopCarMapper.updateShopCarStatus(shopCar.getDid(), shopCar.getUid(), shopCar.getStatus());
        return i;
    }

    @Override
    public ShopCar queryShopCar(Integer carid) {
        ShopCar shopCar = shopCarMapper.queryShopCar(carid);
        return shopCar;
    }

    @Override
    public Integer Order(Integer uid) {
        Integer i = shopCarMapper.Order(uid);
        return i;
    }
}
