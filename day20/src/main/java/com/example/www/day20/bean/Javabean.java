package com.example.www.day20.bean;

public class Javabean {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Javabean{" +
                "result=" + result +
                '}';
    }
}
