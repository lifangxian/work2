package com.example.www.lifangxian20190304.bean;

public class CommodityList {
    private String commodityId;
    private String commodityName;
    private String masterPic;
    private String price;
    private String saleNum;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return "CommodityList{" +
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                ", saleNum='" + saleNum + '\'' +
                '}';
    }
}