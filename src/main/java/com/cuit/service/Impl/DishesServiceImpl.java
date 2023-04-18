package com.cuit.service.Impl;

import com.cuit.mapper.DishesMapper;
import com.cuit.pojo.Dishes;
import com.cuit.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }
}
