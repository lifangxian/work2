package com.example.www.lifangxian20190304.bean;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class JavaBean {
    private String message;
    private Result result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
