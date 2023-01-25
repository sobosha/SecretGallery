package com.example.gallerysecret.Setting;

public class shop_item {

    String name,type,icon;
     int id,quantity,price,fullPrice,isVisible;

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getFullPrice() {
        return fullPrice;
    }
}
