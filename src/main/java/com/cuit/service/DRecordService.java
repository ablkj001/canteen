package com.cuit.service;

import com.cuit.pojo.DRecord;

import java.util.List;

public interface DRecordService {

    //往数据关联网中插入数据，返回改变的数据条数
    Integer addRecord(DRecord dRecord);

    //查询当前店铺的关联数据
    List<DRecord> queryDrecord(Integer sid);

    //从关联表中删除当前店铺的数据
    Integer deleteRecord(Integer sid);
}
