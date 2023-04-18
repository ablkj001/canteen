package com.cuit.mapper;

import com.cuit.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
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
}
