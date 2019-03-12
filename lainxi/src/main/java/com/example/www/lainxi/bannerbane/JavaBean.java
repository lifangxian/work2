package com.example.www.lainxi.bannerbane;

import java.util.ArrayList;



public class JavaBean {
    private ArrayList<Result> result;

    public ArrayList<Result> getResult() {
        return result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "result=" + result +
                '}';
    }
}
