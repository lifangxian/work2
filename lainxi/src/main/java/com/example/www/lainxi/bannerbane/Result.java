package com.example.www.lainxi.bannerbane;

public class Result {
   /* imageUrl": "http://172.17.8.100/images/small/banner/cj.png",
            "jumpUrl": "http://172.17.8.100/htm/lottery/index.html",*/
    private String imageUrl;
    private String jumpUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    @Override
    public String toString() {
        return "Result{" +
                "imageUrl='" + imageUrl + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                '}';
    }
}
