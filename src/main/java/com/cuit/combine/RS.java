package com.cuit.combine;

import com.cuit.pojo.Room;
import com.cuit.pojo.Shop;

import java.util.List;

public class RS {

    private Room room;
    private List<Shop> shops;

    public RS() {
    }

    public RS(Room room, List<Shop> shops) {
        this.room = room;
        this.shops = shops;
    }


    @Override
    public String toString() {
        return "RS{" +
                "room=" + room +
                ", shops=" + shops +
                '}';
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
