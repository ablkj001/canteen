package com.cuit.service;

import com.cuit.pojo.Dishes;

import java.util.List;

public interface DishesService {

    //获取不同店铺的不同商品
    List<Dishes> queryDishesBySid(Integer sid);

    //随机获取7个不同的商品
    List<Dishes> queryRandomDished();
}
