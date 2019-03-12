package com.example.www.lainxi.bean;

public class CommodityList {
 /*   "commodityName": "唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋",
            "masterPic": "http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg",
            "price": 88,
            "saleNum": 0
},
        {
        "commodityId": 18,
        "commodityName": ""commodityId": 32,
        白色经典 秋季新款简约百搭轻便休闲女鞋板鞋小白鞋",
        "masterPic": "http://172.17.8.100/images/small/commodity/nx/bx/1/1.jpg",
        "price": 79,
        "saleNum": 0*/
    private String commodityName;
    private String masterPic;
    private int price;
    private int saleNum;
    private int commodityId;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        return "CommodityList{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price=" + price +
                ", saleNum=" + saleNum +
                ", commodityId=" + commodityId +
                '}';
    }
}
