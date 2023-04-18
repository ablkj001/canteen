package com.cuit.service.Impl;

import com.cuit.mapper.RoomMapper;
import com.cuit.pojo.Room;
import com.cuit.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> queryRoomList() {
        List<Room> rooms = roomMapper.queryRoomList();
        return rooms;
    }

    @Override
    public Integer insertRoom(Room room) {
        Integer i = roomMapper.addRoom(room);
        return i;
    }

    @Override
    public Integer deleteRoom(Integer rid) {
        Integer i = roomMapper.deleteRoom(rid);
        return i;
    }
}
