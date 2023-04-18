package com.cuit;

import com.cuit.pojo.Shop;
import com.cuit.service.Impl.ShopServiceImpl;
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
public class ShopTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    ShopServiceImpl shopService;

    @Test
    void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){
        List<Shop> shops = shopService.queryShopByRid(1);
    }

    @Test
    public void testB(){
        Shop shop = new Shop("天天饺子",1,"二楼楼梯口","王亦","12345678910");
        Integer i = shopService.addShop(shop);
        List<Shop> shops = shopService.queryShopByRid(1);
    }

    @Test
    public void testC(){
        Integer i = shopService.deleteShop(3);
    }
}
