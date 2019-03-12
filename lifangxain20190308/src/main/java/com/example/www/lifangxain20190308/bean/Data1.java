package com.example.www.lifangxain20190308.bean;

public class Data1 {
   /* "title": "浠婅捣鍚堣偉甯傛皯鎷嶈繚鍋滅瓑杩濇硶琛屼负涓炬姤鍙幏濂栧姳 闄勮缁嗘敾鐣�",
            "type"
            "link": "lsapp://cn.ahurls.news/news?id=3706338",*/
    private String title;
    private String type;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Data1{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
