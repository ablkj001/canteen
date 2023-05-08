package com.cuit.service;

import com.cuit.pojo.Dishes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RotationService {
    // 晋升等级
    Integer updateRotationPromote(Integer id);

    // 降低等级
    Integer updateRotationReduce(Integer id);

    // 查询等级1
    List<Dishes> queryFirstGrade(String dname, Integer page);

    // 查询等级2
    List<Dishes> querySecondGrade(String dname, Integer page);

    // 获取总数
    Integer countRotation(String dname, Integer level);

    // 随机获取7张轮播图
    List<Dishes> randomRotation();
}
