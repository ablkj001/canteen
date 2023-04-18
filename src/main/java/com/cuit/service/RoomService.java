package com.cuit.service;

import com.cuit.pojo.Room;

import java.util.List;

public interface RoomService {

    List<Room> queryRoomList();

    Integer insertRoom(Room room);

    Integer deleteRoom(Integer rid);
}
