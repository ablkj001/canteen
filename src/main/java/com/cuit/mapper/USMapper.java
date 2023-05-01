package com.cuit.mapper;

import com.cuit.pojo.US;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface USMapper {

    //插入新的数据
    Integer addUS(@Param("uid") Integer uid,@Param("sid") Integer sid);

    //查询管理员与店铺之间的关系
    US queryUS(@Param("uid") Integer uid);
}
