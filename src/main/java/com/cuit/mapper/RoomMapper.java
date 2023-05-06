package com.cuit.mapper;

import com.cuit.pojo.Room;
import com.cuit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    //分页获取所有食堂
    List<Room> queryRoomByPage(@Param("page") Integer page);

    //返回食堂的总数
    Integer countRoom();

    //根据食堂ID或食堂名称查找食堂
    List<Room> queryRoomByRidOrRname(@Param("keyword") String keyword,@Param("page") Integer page);

    //编辑食堂信息
    Integer editRoom(Room room);

    //根据食堂ID获取食堂
    Room queryRoomByRid(@Param("rid") Integer rid);

    //获取查询后的食堂总数
    Integer countQueryRoom(@Param("keyword") String keyword,@Param("page") Integer page);

    //修改食堂的状态
    Integer roomStatus(@Param("rid") Integer rid,@Param("status") Integer status);

}
