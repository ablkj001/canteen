package com.cuit.mapper;

import com.cuit.pojo.Room;
import com.cuit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {

    //获取所有食堂
    List<Room> queryRoomList();

    //添加食堂
    Integer addRoom(Room room);

    //删除食堂
    Integer deleteRoom(Integer rid);
}
