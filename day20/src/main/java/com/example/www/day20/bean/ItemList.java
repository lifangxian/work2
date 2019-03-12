package com.example.www.day20.bean;

public class ItemList {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "data=" + data +
                '}';
    }
}
