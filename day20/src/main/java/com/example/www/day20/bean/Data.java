package com.example.www.day20.bean;

public class Data  {
//    actionUrl": "eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A",
//            "dataType": "BriefCard",
//            "description": "为广告人的精彩创意点赞",
//            "expert": false,
    private String actionUrl;
    private String dataType;
    private String description;
    private String icon;

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Data{" +
                "actionUrl='" + actionUrl + '\'' +
                ", dataType='" + dataType + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }


}
