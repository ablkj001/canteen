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

    //根据页数获取菜品
    List<Dishes> queryDishesByPage(Integer page,Integer sid, Integer pagesize);

    //根据菜品名来查询
    List<Dishes> queryDishesByDname(String dname,Integer sid,Integer page);

    //获取当前店铺菜品的总数
    Integer countDishes(Integer sid);

    //获取查询后菜品的数量
    Integer countDishesByDname(String dname,Integer sid);

    //改变菜品上下架状态
    Integer changeDishesStatus(Integer did,Integer status);

    //新增菜品
    Integer addDishes(Dishes dishes);

    //编辑菜品
    void editDishes(Dishes dishes);

    //获取菜品的状态
    Dishes checkDishes(String dname,Integer sid);

    //根据店铺ID以及菜品名获取菜品
    Dishes queryDishesBySidAndDname(Integer sid,String dname);

    //将当前的店铺的菜品均置为下架状态
    Integer changeStatusBySid(Integer sid);
}
