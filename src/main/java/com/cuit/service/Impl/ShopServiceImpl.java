package com.cuit.service.Impl;

import com.cuit.mapper.ShopMapper;
import com.cuit.pojo.Shop;
import com.cuit.service.ShopService;
import com.cuit.util.LoginResultEnum;
import com.cuit.util.RegisterResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    RegisterResultEnum registerResultEnum =null;

    @Override
    public List<Shop> queryShopByRid(Integer rid) {
        List<Shop> shops = shopMapper.queryShopByRid(rid);
        return shops;
    }

    @Override
    public RegisterResultEnum addShop(Shop shop) {
        if(shopMapper.queryShopBySnameRid(shop.getSname(),shop.getRid()) != null){
            registerResultEnum = RegisterResultEnum.SHOPNAME_DUPLICATED;
        }else {
            shopMapper.addShop(shop);
            registerResultEnum = RegisterResultEnum.SUCCESS;
        }
        return registerResultEnum;
    }

    @Override
    public Integer deleteShop(Integer sid) {
        Integer i =shopMapper.deleteShop(sid);
        return i;
    }

    @Override
    public Shop queryShopBySid(Integer sid) {
        Shop shop = shopMapper.queryShopBySid(sid);
        return shop;
    }

    @Override
    public Shop queryShopBySname(String sname) {
        Shop shop = shopMapper.queryShopBySname(sname);
        return shop;
    }

    @Override
    public Shop queryShopBySnameRid(String sname, Integer rid) {
        Shop shop = shopMapper.queryShopBySnameRid(sname,rid);
        return shop;
    }

    @Override
    public List<Shop> queryShopBySnameOrSid(Integer sid, String sname, Integer page) {
        List<Shop> shops = shopMapper.queryShopBySnameOrSid(sname,sid,page);
        return shops;
    }

    @Override
    public Integer editShop(Shop shop) {
        Integer i = shopMapper.editShop(shop);
        return i;
    }

    @Override
    public List<Shop> queryShopByPage(Integer page) {
        List<Shop> shops = shopMapper.queryShopByPage(page);
        return shops;
    }

    @Override
    public Integer countShop() {
        Integer i = shopMapper.countShop();
        return i;
    }
}
