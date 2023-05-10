package com.cuit.mapper;

import com.cuit.pojo.US;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface USMapper {

    //插入新的数据
    Integer addUS(US us);

    //查询管理员与店铺之间的关系
    US queryUS(@Param("uid") Integer uid);

    //根据sid查询店铺与管理员的关系
    US queryUSBySid(@Param("sid") Integer sid);
}
