package com.example.www.lifangxain20190308.bean;

public class Javabean {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Javabean{" +
                "data=" + data +
                '}';
    }
}
