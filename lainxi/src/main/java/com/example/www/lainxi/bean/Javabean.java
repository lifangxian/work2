package com.example.www.lainxi.bean;

public class Javabean {
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
        return "Javabean{" +
                "message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
