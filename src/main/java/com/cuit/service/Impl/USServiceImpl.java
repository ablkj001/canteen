package com.cuit.service.Impl;

import com.cuit.mapper.USMapper;
import com.cuit.pojo.US;
import com.cuit.service.USService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class USServiceImpl implements USService {

    @Autowired
    private USMapper usMapper;


    @Override
    public Integer addService(Integer uid, Integer sid) {
        US us = new US(uid,sid);
        Integer i = usMapper.addUS(us);
        return i;
    }

    @Override
    public US queryUS(Integer uid) {
        US us = usMapper.queryUS(uid);
        return us;
    }

    @Override
    public US queryUSBySid(Integer sid) {
        US us = usMapper.queryUSBySid(sid);
        return us;
    }
}
