package com.cuit.mapper;

import com.cuit.pojo.OU;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OUMapper {

    //往用户订单信息表中插入数据
    Integer addOU(OU ou);

    //从用户订单关系表中分页读取数据
    List<OU> queryOU(@Param("uid") Integer uid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //统计用户订单关系表中数据的总数
    Integer countOU(@Param("uid") Integer uid);
}
