package com.example.www.day20.bean;

import java.util.ArrayList;

public class Result {

//    adExist": false,
//            "count": 18,
//            "itemList": [
    private String count;
    private ArrayList<ItemList> itemList;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemList> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Result{" +
                "count='" + count + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
