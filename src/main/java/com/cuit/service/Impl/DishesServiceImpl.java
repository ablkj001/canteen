package com.cuit.service.Impl;

import com.cuit.mapper.DishesMapper;
import com.cuit.pojo.Dishes;
import com.cuit.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DishesServiceImpl implements DishesService {

    @Autowired
    private DishesMapper dishesMapper;

    @Override
    public List<Dishes> queryDishesBySid(Integer sid) {
        List<Dishes> dishes = dishesMapper.queryDishesBySid(sid);
        return dishes;
    }

    @Override
    public List<Dishes> queryRandomDished() {
        Integer total = dishesMapper.queryAllDishes().size();
        Set<Integer> set = new HashSet<>();
        while (true){
            int num = (int)(Math.random()*total+1);
            set.add(num);
            if(set.size() == 7){
                break;
            }
        }
        List<Dishes> dishesList = new ArrayList<>();
        for (Integer did:set){
            Dishes dishes = dishesMapper.queryDishesByDid(did);
            dishesList.add(dishes);
        }
        System.out.println(dishesList);
        return dishesList;
    }

    @Override
    public Dishes queryDishesByDid(Integer did) {
        Dishes dishes = dishesMapper.queryDishesByDid(did);
        return dishes;
    }

    @Override
    public List<Dishes> queryDishesByStatus(Integer sid) {
        List<Dishes> dishes = dishesMapper.queryDishesByDstatus(sid);
        return dishes;
    }

    @Override
    public List<Dishes> queryDishesByPage(Integer page, Integer sid) {
        List<Dishes> dishes = dishesMapper.queryDishesByPage(page,sid);
        return dishes;
    }

    @Override
    public List<Dishes> queryDishesByDname(String dname, Integer sid,Integer page) {
        List<Dishes> dishes = dishesMapper.queryDishesByDname(dname,sid,page);
        return dishes;
    }

    @Override
    public Integer countDishes(Integer sid) {
        Integer i = dishesMapper.countDishes(sid);
        return i;
    }

    @Override
    public Integer countDishesByDname(String dname, Integer sid) {
        Integer i = dishesMapper.countDishesByDname(dname,sid);
        return i;
    }

    @Override
    public Integer changeDishesStatus(Integer did, Integer status) {
        Integer i = dishesMapper.changeDishesStatus(did,status);
        return i;
    }

    @Override
    public Integer addDishes(Dishes dishes) {
        Integer i = dishesMapper.addDishes(dishes.getDname(),dishes.getDprice(),dishes.getDimage(),dishes.getSid(),dishes.getDetail(),dishes.getSwiper());
        return i;
    }

    @Override
    public void editDishes(Dishes dishes) {
        dishesMapper.editDishes(dishes);
    }

    @Override
    public Dishes checkDishes(String dname, Integer sid) {
        Dishes dishes = dishesMapper.queryDishesByDnameSid(dname,sid);
        return dishes;
    }
}
