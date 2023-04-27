package com.cuit.service;

import com.cuit.pojo.Dishes;

import java.util.List;

public interface DishesService {

    //根据店铺ID获取菜品
    List<Dishes> queryDishesBySid(Integer sid);

    //随机获取7个不同菜品
    List<Dishes> queryRandomDished();

    //根据did获取商品
    Dishes queryDishesByDid(Integer did);

    //获取未下架菜品
    List<Dishes> queryDishesByStatus(Integer sid);
}
