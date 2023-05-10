package com.cuit.mapper;

import com.cuit.pojo.Shop;
import com.cuit.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper {

    //通过食堂ID获取所属店铺
    List<Shop> queryShopByRid(Integer rid);

    //添加店铺
    Integer addShop(Shop shop);

    //删除店铺
    Integer deleteShop(Integer sid);

    //根据sid查找店铺
    Shop queryShopBySid(Integer sid);

    //根据sname查找店铺
    Shop queryShopBySname(String sname);

    //根据sname以及rid获取店铺
    Shop queryShopBySnameRid(@Param("sname") String sname, @Param("rid") Integer rid);

    //根据店铺名或店铺ID查询店铺
    List<Shop> queryShopBySnameOrSid(@Param("keyword") String keyword,@Param("page") Integer page);

    //编辑店铺信息
    Integer editShop(Shop shop);

    //分页获取所有店铺
    List<Shop> queryShopByPage(@Param("page") Integer page);

    //获取店铺总数
    Integer countShop();

    //获取查询后店铺的总数
    Integer countQueryShop(@Param("keyword") String keyword);

    //删除食堂后改变店铺的状态
    Integer changeShopStatus(@Param("rid") Integer rid);

    //供购物车查询的语句
    Shop queryShopCarBySid(@Param("sid") Integer sid);
}
