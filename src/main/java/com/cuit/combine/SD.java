package com.cuit.combine;

import com.cuit.pojo.Dishes;
import com.cuit.pojo.Shop;

import java.util.List;

public class SD {

    private Shop shop;
    private List<Dishes> dishes;

    public SD() {
    }

    public SD(Shop shop, List<Dishes> dishes) {
        this.shop = shop;
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "SD{" +
                "shop=" + shop +
                ", dishes=" + dishes +
                '}';
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }
}
