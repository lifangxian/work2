package com.example.www.lifangxain20190308.bean;

import java.util.ArrayList;

public class Data {
    private ArrayList<Data1> data;

    public ArrayList<Data1> getData() {
        return data;
    }

    public void setData(ArrayList<Data1> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
