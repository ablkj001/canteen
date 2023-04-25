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
    List<Dishes> queryDishesBySid(@Param("sid") Integer sid,@Param("status") Integer status);

    //通过did获取商品
    Dishes queryDishesByDid(@Param("did") Integer did,@Param("status") Integer status);

    //添加菜品
    Integer addDishes(Dishes dishes);

    //下架菜品
    Integer deleteDishes(Integer did);

    //获取所有菜品
    List<Dishes> queryAllDishes();
}
