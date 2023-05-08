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

    //从用户订单关系表中分页读取未完成的数据
    List<OU> queryOUY(@Param("uid") Integer uid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //从用户订单关系表中分页读取已完成的数据
    List<OU> queryOUN(@Param("uid") Integer uid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //统计已完成的用户订单关系表中数据的总数
    Integer countOUY(@Param("uid") Integer uid);

    //统计未完成的用户订单关系表中数据的总数
    Integer countOUN(@Param("uid") Integer uid);

    //更新用户订单关系表的状态
    Integer editOUStatus(@Param("ouid") Integer ouid,@Param("status") Integer status);

    //根据orderid获取用户订单关系
    OU queryOUByOrderid(@Param("orderid") String orderid);
}
