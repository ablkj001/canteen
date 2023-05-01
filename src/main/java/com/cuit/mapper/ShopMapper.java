package com.cuit.mapper;

import com.cuit.pojo.Shop;
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
    List<Shop> queryShopBySnameOrSid(@Param("sname") String sname,@Param("sid") Integer sid,@Param("page") Integer page);

    //编辑店铺信息
    Integer editShop(Shop shop);

    //分页获取所有店铺
    List<Shop> queryShopByPage(@Param("page") Integer page);

    //获取店铺总数
    Integer countShop();
}
