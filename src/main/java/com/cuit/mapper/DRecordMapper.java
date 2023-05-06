package com.cuit.mapper;

import com.cuit.pojo.DRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DRecordMapper {

    //往关联表中插入数据
    Integer addRecord(DRecord dRecord);

    //查询当前店铺的关联数据
    List<DRecord> queryDrecord(@Param("sid") Integer sid);

    //从关联表中删除当前店铺的数据
    Integer deleteRecord(@Param("sid") Integer sid);
}
