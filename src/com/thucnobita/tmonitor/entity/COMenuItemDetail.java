package com.thucnobita.tmonitor.entity;

public class COMenuItemDetail
extends COBaseItem {
    private double price;
    private double kalo;
    private String otherName;

    public COMenuItemDetail() {
    	this.price = 0;
    	this.kalo = 100;
    	this.otherName = "";
    }
    
    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKalo() {
        return this.kalo;
    }

    public void setKalo(double kalo) {
        this.kalo = kalo;
    }
}