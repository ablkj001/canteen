package com.cuit;

import com.cuit.mapper.ShopCarMapper;
import com.cuit.pojo.ShopCar;
import com.cuit.service.ShopCarService;
import com.cuit.service.ShopService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //按照指定方法运行
public class ShopCarTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    ShopCarMapper shopCarMapper;

    @Autowired
    ShopCarService shopCarService;

    @Test
    void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){
        ShopCar shopCar = new ShopCar(7,5,4,1);
        Integer i = shopCarService.addShopCar(shopCar);
        System.out.println(i);
    }

    @Test
    public void testB(){
        List<ShopCar> shopCars = shopCarService.queryShopcarByUid(7);
    }

    @Test
    public void testC(){
        Integer i = shopCarMapper.countShopCarByDid(1,7);
        System.out.println(i);
    }

    @Test
    public void testD(){
        Integer i = shopCarMapper.updateShopCarByDid(5,7,2);
        List<ShopCar> shopCars = shopCarMapper.queryShopcarByUid(7);
    }
}
