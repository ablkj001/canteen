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

    //从订单店铺关系表中分页读取数据
    List<OS> queryOS(@Param("sid") Integer sid,@Param("page") Integer page,@Param("pagesize") Integer pagesize);

    //统计订单店铺关系表中数据的总数
    Integer countOS(@Param("sid") Integer sid);
}
