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

    @Override
    public List<Room> queryRoomByPage(Integer page) {
        List<Room> rooms = roomMapper.queryRoomByPage(page);
        return rooms;
    }

    @Override
    public Integer countRoom() {
        Integer i = roomMapper.countRoom();
        return i;
    }

    @Override
    public List<Room> queryRoomByRidOrRname(Integer rid, String rname,Integer page) {
        List<Room> rooms = roomMapper.queryRoomByRidOrRname(rid,rname,page);
        return rooms;
    }

    @Override
    public Integer editRoom(Room room) {
        Integer i = roomMapper.editRoom(room);
        return i;
    }

    @Override
    public Room queryRoomByRid(Integer rid) {
        Room room = roomMapper.queryRoomByRid(rid);
        return room;
    }
}
