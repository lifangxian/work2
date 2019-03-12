package com.example.www.week3.bena;

import java.util.ArrayList;

public class Result {
    /*bg_color": "0xFBEFE6",
            "": "http://business0.qianqian.com/qianqian/file/5bfe4e9aa7496_218.png",
            "color": "0xDC5900",
            "comment": "该榜单是根据千千音乐平台歌曲每周播放量自动生成的数据榜单，统计范围为千千音乐平台上的全部歌曲，每日更新一次",
            "content":*/
    private String bg_color;
    private String bg_pic;
    private String color;
    private String comment;
    private ArrayList<Contet> content;

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getBg_pic() {
        return bg_pic;
    }

    public void setBg_pic(String bg_pic) {
        this.bg_pic = bg_pic;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ArrayList<Contet> getContent() {
        return content;
    }

    public void setContent(ArrayList<Contet> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Result{" +
                "bg_color='" + bg_color + '\'' +
                ", bg_pic='" + bg_pic + '\'' +
                ", color='" + color + '\'' +
                ", comment='" + comment + '\'' +
                ", content=" + content +
                '}';
    }
}
