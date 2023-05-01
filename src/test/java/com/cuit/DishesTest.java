package com.cuit;

import com.cuit.mapper.DishesMapper;
import com.cuit.pojo.Dishes;
import com.cuit.service.DishesService;
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
public class DishesTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    private DishesMapper dishesMapper;

    @Autowired
    private DishesService dishesService;

    @Test
    void test() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    public void testA(){
        List<Dishes> dishes = dishesMapper.queryDishesBySid(4);
        System.out.println(dishes);
    }

    @Test
    public void testB(){
        Dishes dishes = dishesMapper.queryDishesByDid(5);
        System.out.println(dishes);
    }

    @Test
    public void testC(){
        Dishes dishes = new Dishes("清汤饺",12,"",5,"");
//        Integer i = dishesMapper.addDishes(dishes);
    }

    @Test
    public void testD(){
        List<Dishes> dishes = dishesService.queryRandomDished();
    }

    @Test
    public void testE(){
        Integer i = dishesService.countDishes(5);
        System.out.println(i);
    }

    @Test
    public void testF(){
        Dishes dishes = new Dishes("水煮牛肉",20,"",9,"牛肉","");
        Integer i = dishesService.addDishes(dishes);
    }

    @Test
    public void testG(){
        Dishes dishes = new Dishes("水煮牛肉",22,"",9,"最近牛肉涨价了","");
        dishes.setDid(18);
        dishesMapper.editDishes(dishes);
    }
}
