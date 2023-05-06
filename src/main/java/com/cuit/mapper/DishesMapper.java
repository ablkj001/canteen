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
    Integer addDishes(@Param("dname") String dname,@Param("dprice") Integer dprice,@Param("dimage") String dimage,@Param("sid") Integer sid,@Param("detail") String detail,@Param("swiper") String swiper);

    //下架菜品
    Integer deleteDishes(Integer did);

    //获取未下架商品
    List<Dishes> queryDishesByDstatus(@Param("sid") Integer sid);

    //获取所有菜品
    List<Dishes> queryAllDishes();

    //根据页数获取菜品，默认一页七个菜品
    List<Dishes> queryDishesByPage(@Param("page") Integer page,@Param("sid") Integer sid,@Param("pagesize") Integer pagesize);

    //根据菜品名进行查询
    List<Dishes> queryDishesByDname(@Param("dname") String dname,@Param("sid") Integer sid,@Param("page") Integer page);

    //菜品的上下架操作
    Integer changeDishesStatus(@Param("did") Integer did,@Param("status") Integer status);

    //返回当前店铺菜品的数量
    Integer countDishes(@Param("sid") Integer sid);

    //返回查询后店铺中菜品的数量
    Integer countDishesByDname(@Param("dname") String dname,@Param("sid") Integer sid);

    //编辑菜品
    Integer editDishes(Dishes dishes);

    //根据菜品名以及店铺ID获取菜品
    Dishes queryDishesByDnameSid(@Param("dname") String dname,@Param("sid") Integer sid);

    //根据店铺ID以及菜品名获取菜品
    Dishes queryDishesBySidAndDname(@Param("sid") Integer sid,@Param("dname") String dname);

    //将当前的店铺的菜品均置为下架状态
    Integer changeStatusBySid(@Param("sid") Integer sid);
}
