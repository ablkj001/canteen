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
        List<Dishes> dishes = dishesMapper.queryDishesBySid(sid,0);
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
            Dishes dishes = dishesMapper.queryDishesByDid(did,0);
            dishesList.add(dishes);
        }
        System.out.println(dishesList);
        return dishesList;
    }

    @Override
    public Dishes queryDishesByDid(Integer did) {
        Dishes dishes = dishesMapper.queryDishesByDid(did,0);
        return dishes;
    }
}
