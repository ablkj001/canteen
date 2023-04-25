package com.cuit.mapper;

import com.cuit.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopCarMapper {

    //往购物车中添加菜品
    Integer addShopCar(ShopCar shopCar);

    //查询该用户购物车中的菜品
    List<ShopCar> queryShopcarByUid(Integer uid);

    //单次移除购物车中的菜品
    Integer deleteShopCar(Integer carid);

    //查询该用户是否已经将该菜品添加进购物车，返回菜品的数量
    Integer countShopCarByDid(@Param("did") Integer did,@Param("uid") Integer uid);

    //更新购物车中的菜品数量（在店铺界面的更新）
    Integer updateShopCarByDid(@Param("did") Integer did,@Param("uid") Integer uid,@Param("count") Integer count);

    //购物车界面对菜品数量的更新
    Integer updateShopCar(@Param("did") Integer did,@Param("uid") Integer uid,@Param("count") Integer count);

    //勾选购物车中的菜品
    Integer updateShopCarStatus(@Param("did") Integer did,@Param("uid") Integer uid,@Param("status") Integer status);
}
