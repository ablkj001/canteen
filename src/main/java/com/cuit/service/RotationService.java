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
    List<Dishes> queryFirstGrade(Integer page);

    // 查询等级2
    List<Dishes> querySecondGrade(Integer page);

    // 获取总数
    Integer countRotation(@Param("did") Integer level);
}
