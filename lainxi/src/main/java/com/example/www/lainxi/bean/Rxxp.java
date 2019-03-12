package com.example.www.lainxi.bean;

import java.util.ArrayList;

public class Rxxp {
    private ArrayList<CommodityList> commodityList;
    private int id;
    private String name;

    public ArrayList<CommodityList> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(ArrayList<CommodityList> commodityList) {
        this.commodityList = commodityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rxxp{" +
                "commodityList=" + commodityList +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
