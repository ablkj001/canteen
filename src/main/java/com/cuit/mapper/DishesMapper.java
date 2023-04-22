package com.cuit.mapper;

import com.cuit.pojo.Dishes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishesMapper {

    //通过sid获取商品
    List<Dishes> queryDishesBySid(Integer sid);

    //通过did获取商品
    Dishes queryDishesByDid(Integer did);

    //添加菜品
    Integer addDishes(Dishes dishes);

    //下架菜品
    Integer deleteDishes(Integer did);
}
