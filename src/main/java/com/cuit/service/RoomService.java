package com.cuit.service;

import com.cuit.pojo.Room;

import java.util.List;

public interface RoomService {

    List<Room> queryRoomList();

    Integer insertRoom(Room room);

    Integer deleteRoom(Integer rid);

    //分页获取食堂
    List<Room> queryRoomByPage(Integer page);

    //获取食堂总数
    Integer countRoom();

    //根据食堂ID或食堂名称查找食堂
    List<Room> queryRoomByRidOrRname(Integer rid,String rname,Integer page);

    //编辑食堂信息
    Integer editRoom(Room room);

    //根据食堂ID获取食堂
    Room queryRoomByRid(Integer rid);
}
