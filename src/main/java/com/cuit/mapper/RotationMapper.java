package com.cuit.mapper;

import com.cuit.pojo.Dishes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RotationMapper {
    // 晋升等级
    Integer updateRotationPromote(@Param("did") Integer id);

    // 降低等级
    Integer updateRotationReduce(@Param("did") Integer id);

    // 查询等级1
    List<Dishes> queryFirstGrade(Integer page);

    // 查询等级2
    List<Dishes> querySecondGrade(Integer page);

    // 获取总数
    Integer countRotation(@Param("swiperlevel") Integer level);
}
