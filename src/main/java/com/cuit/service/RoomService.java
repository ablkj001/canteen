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
    List<Room> queryRoomByRidOrRname(String keyword,Integer page);

    //编辑食堂信息
    Integer editRoom(Room room);

    //根据食堂ID获取食堂
    Room queryRoomByRid(Integer rid);

    //获取分页查询后的食堂总数
    Integer countQueryRoom(String keyword,Integer page);

    //修改食堂的状态
    Integer roomStatus(Integer rid,Integer status);
}
