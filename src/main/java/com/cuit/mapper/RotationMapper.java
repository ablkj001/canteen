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
    List<Dishes> queryFirstGrade(@Param("dname") String dname, Integer page);

    // 查询等级2
    List<Dishes> querySecondGrade(@Param("dname") String dname, Integer page);

    // 获取总数
    Integer countRotation(@Param("dname") String dname, @Param("swiperlevel") Integer level);

    // 随机获取7张轮播图
    List<Dishes> randomRotation();
}
