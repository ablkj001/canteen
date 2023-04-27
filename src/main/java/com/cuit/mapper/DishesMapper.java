package com.cuit.mapper;

import com.cuit.pojo.Dishes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishesMapper {

    //通过sid获取商品
    List<Dishes> queryDishesBySid(@Param("sid") Integer sid);

    //通过did获取商品
    Dishes queryDishesByDid(@Param("did") Integer did);

    //添加菜品
    Integer addDishes(Dishes dishes);

    //下架菜品
    Integer deleteDishes(Integer did);

    //获取未下架商品
    List<Dishes> queryDishesByDstatus(@Param("sid") Integer sid);

    //获取所有菜品
    List<Dishes> queryAllDishes();
}
