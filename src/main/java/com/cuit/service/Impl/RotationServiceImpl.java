package com.cuit.service.Impl;

import com.cuit.mapper.RotationMapper;
import com.cuit.pojo.Dishes;
import com.cuit.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图的Service
 */
@Service
public class RotationServiceImpl implements RotationService {

    @Autowired
    private RotationMapper rotationMapper;

    // 晋升等级
    @Override
    public Integer updateRotationPromote(Integer id) { return rotationMapper.updateRotationPromote(id); };

    // 降低等级
    @Override
    public Integer updateRotationReduce(Integer id) { return rotationMapper.updateRotationPromote(id); }

    // 查询等级1
    @Override
    public List<Dishes> queryFirstGrade(Integer page) { return rotationMapper.queryFirstGrade(page); }

    // 查询等级2
    @Override
    public List<Dishes> querySecondGrade(Integer page) { return rotationMapper.querySecondGrade(page); }

    // 获取总数
    @Override
    public Integer countRotation(Integer level) { return rotationMapper.countRotation(level); }

}
