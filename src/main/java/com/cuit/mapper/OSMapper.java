package com.cuit.mapper;

import com.cuit.pojo.OS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OSMapper {

    //往订单店铺关联表中插入数据
    Integer addOS(OS os);

    //从订单店铺关系表中分页读取已完成订单数据
    List<OS> queryOSY(@Param("sid") Integer sid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //从订单店铺关系表中分页读取未完成订单数据
    List<OS> queryOSN(@Param("sid") Integer sid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //统计订单店铺关系表中已完成订单的总数
    Integer countOSY(@Param("sid") Integer sid);

    //统计订单店铺关系表中未完成订单数据的总数
    Integer countOSN(@Param("sid") Integer sid);

    //更新店铺订单关系表
    Integer edirOSStatus(@Param("osid") Integer osid,@Param("status") Integer status);

    //根据orderid获取店铺订单关系
    OS queryOSByOrderid(@Param("orderid") String orderid);
}
