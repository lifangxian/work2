package com.example.www.lifangxian20190304.bean;

import java.util.ArrayList;

public class Mlss  {

    private ArrayList<CommodityList> commodityList;

    public ArrayList<CommodityList> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(ArrayList<CommodityList> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "Mlss{" +
                "commodityList=" + commodityList +
                '}';
    }
}
