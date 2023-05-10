package com.cuit.service;

import com.cuit.pojo.Shop;
import com.cuit.pojo.ShopCar;
import com.cuit.util.RegisterResultEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {

    //通过食堂id查询店铺
    List<Shop> queryShopByRid(Integer rid);

    //店铺注册
    RegisterResultEnum addShop(Shop shop);

    //移除店铺
    Integer deleteShop(Integer sid);

    //根据店铺id获取店铺对象
    Shop queryShopBySid(Integer sid);

    //根据店铺名获取店铺对象
    Shop queryShopBySname(String sname);

    //根据店铺以及食堂名获取对象
    Shop queryShopBySnameRid(String sname,Integer rid);

    //根据店铺ID或店铺名获取店铺
    List<Shop> queryShopBySnameOrSid(String keyword,Integer page);

    //编辑用户的信息
    Integer editShop(Shop shop);

    //分页获取所有店铺
    List<Shop> queryShopByPage(Integer page);

    //获取店铺总数
    Integer countShop();

    //获取查询后店铺的总数
    Integer countQueryShop(String keyword);

    //改变店铺状态
    Integer changeShopStatus(Integer rid);

    //供购物车查询的语句
    Shop queryShopCarDishesBySid(Integer sid);
}
