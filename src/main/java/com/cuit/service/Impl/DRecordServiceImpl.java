package com.cuit.service.Impl;

import com.cuit.mapper.DRecordMapper;
import com.cuit.pojo.DRecord;
import com.cuit.service.DRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DRecordServiceImpl implements DRecordService {

    @Autowired
    private DRecordMapper dRecordMapper;

    @Override
    public Integer addRecord(DRecord dRecord) {
        Integer i = dRecordMapper.addRecord(dRecord);
        return i;
    }

    @Override
    public List<DRecord> queryDrecord(Integer sid) {
        List<DRecord> dRecords = dRecordMapper.queryDrecord(sid);
        return dRecords;
    }

    @Override
    public Integer deleteRecord(Integer sid) {
        Integer i = dRecordMapper.deleteRecord(sid);
        return i;
    }
}
